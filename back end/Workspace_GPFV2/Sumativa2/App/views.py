from django.shortcuts import render, redirect
from App.admin import proyectoAdmin
from App.models import reservas
from App.forms import Formreservas
from . import forms
from django.http import HttpResponseRedirect
# Create your views here.

def agregarReserva(request):
    form = forms.Formreservas()
    
    if (request.method =='POST'):
        form = forms.Formreservas(request.POST)
        if(form.is_valid()):
            print("Form es Valido")
            #print("Nombre: ", forms.Formreservas.clean(['nombre']))
            #print("Telefono: ",forms.Formreservas.clean['telefono'])
            #print("Donante: ",forms.Formreservas.clean['donante'])
            form.save()
            return redirect('/')
           
    titulo = 'AGREGAR RESERVA'
    texto = 'Agregar'        
    res = reservas.objects.all()
    data ={'formularios': res, 'form': form, 'texto': texto, 'titulo':titulo}      
    return render(request, 'templatesApp/agregar.html', data)


def listado(request):
    forms = reservas.objects.all()
    data={'forms' : forms}
    return render(request, 'templatesApp/agregar.html', data)


def eliminarReserva(request, id):
    formularios = reservas.objects.get(id=id)
    formularios.delete()
    return HttpResponseRedirect("/")


def actualizarReserva(request,id):
    res = reservas.objects.get(id = id)
    form = Formreservas(instance = res)
    if (request.method =='POST'):
        form = Formreservas(request.POST, instance = res)
        if(form.is_valid()):
            form.save()
            return redirect('/')
    titulo= 'MODIFICAR RESERVA'
    texto = 'ACTUALIZAR'
    res = reservas.objects.all()
    data = {'formularios': res, 'form':form, 'titulo':titulo , 'texto':texto}
    return render (request, 'templatesApp/agregar.html', data)
           
    #titulo = 'AGREGAR RESERVA'
    #texto = 'Agregar'        
    #res = reservas.objects.all()
    #data ={'formularios': res, 'form': form, 'texto': texto, 'titulo':titulo}      
    #return render(request, 'templatesApp/agregar.html', data)