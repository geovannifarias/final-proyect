from django.shortcuts import render , redirect
from django.db.models import Q
from App.models import Prog_tipo_solicitud
from App.models import  Prog_estado_civil
from App.models import  Prog_solicitud

from .forms import FormSolicitud

# Create your views here.
def Principal(request):

    return render(request, 'templatesApp/paginaPrincipal.html')

def Solicitud(request):
    formAdd = FormSolicitud()
    if request.method == 'POST':
        formAdd = FormSolicitud(request.POST)
        if formAdd.is_valid():
            formAdd.save()
            return redirect(listado)
    else:
        formAdd = FormSolicitud()
    
    data = {'formAdd':formAdd}
    return render(request, 'templatesApp/solicitud.html', data)

#----------------------LISTADOS------------------------------
def listado(request):

    mostrar = Prog_solicitud.objects.all()

    busqueda = request.GET.get("buscador")
    if busqueda:
        mostrar = Prog_solicitud.objects.filter(
            Q(nombres__icontains = busqueda) |
            Q(apellido_paterno__icontains = busqueda) |
            Q(apellido_materno__icontains = busqueda) |
            Q(dv__icontains = busqueda) |
            Q(tobservaciones__icontains = busqueda) |
            Q(id_solicitud__icontains = busqueda) |
            Q(rut__icontains = busqueda)
        ).distinct()
 
    data = {'mostrar':mostrar}
    return render(request , 'templatesApp/listado.html', data)
















#def Buscador():
 #   busqueda = request.POST.get("buscar")
  #  solicitudd = Prog_solicitud.objects.all()
  #  if busqueda:
  #      solicitudd = Prog_solicitud.objects.filter(
  #          Q(id_solicitud__icontains = busqueda) |
  #          Q(ctipo_solicitud__icontains = busqueda) |
  #          Q(nombres__icontains = busqueda) |
  #          Q(apellido_paterno__icontains = busqueda) |
  #          Q( apellido_materno__icontains = busqueda) |
  #          Q(rut__icontains = busqueda) |
  #          Q(dv__icontains = busqueda) |
  #          Q(fnacimiento__icontains = busqueda) |
  #          Q(cestado_civil__icontains = busqueda) |
  #          Q(cdonante__icontains = busqueda) |
  #          Q(fsolicitud__icontains = busqueda) |
  #          Q(tobservaciones__icontains = busqueda)
  #      ).distinct()
  #  return render(request, 'listado.html', {'solicitudd': solicitudd})



















#def agregarReserva(request):
 #   formu=reservaForm()
  #  if(request.method=='POST'):
   #     formu=reservaForm(request.POST)
    #    if(formu.is_valid()):
     #       formu.save()
      #      return redirect('/agregarReserva')
                
   # reservas=Reserva.objects.all()
    #data={'formu':formu, 'reservas':reservas}
    #return render(request, 'templatesApp/agregar.html',data)