from django.shortcuts import render

# Create your views here.
def mostrarPaginaInicio(request):
    return render(request, 'templatesAdmApp/index.html')#(request,template, data)

def listarProyectos(request):
    data={
        'titulo':'LISTADO DE PROYECTO'
    }
    return render(request, 'templatesAdmApp/proyectos.html',data)

def agregarProyecto(request):
    data={
        'titulo':'AGREGAR UN PROYECTO'
    }
    return render(request, 'templatesAdmApp/agregar.html',data)
    
def actualizarProyecto(request):
    data={
        'titulo':'ACTUALIZAR PROYECTO'
    }
    return render(request, 'templatesAdmApp/agregar.html',data)

def eliminarProyecto(request):
    return render(request, 'templatesAdmApp/proyectos.html')