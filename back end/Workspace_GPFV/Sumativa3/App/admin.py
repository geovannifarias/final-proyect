from django.contrib import admin
from .models import Prog_tipo_solicitud , Prog_solicitud ,Prog_estado_civil

# Register your models here.

class Prog_tipo_solicitud_Admin(admin.ModelAdmin):
    list_display = ('ctipo_solicitud','tipo_solicitud')

admin.site.register(Prog_tipo_solicitud , Prog_tipo_solicitud_Admin)



class Prog_estado_Civil_Admin(admin.ModelAdmin):
    list_display = ('cestado_civil','estado_civil')
admin.site.register(Prog_estado_civil , Prog_estado_Civil_Admin)


class Prog_solicitud_Admin(admin.ModelAdmin):
    list_display = ('ctipo_solicitud' , 'nombres' , 'apellido_paterno' ,
     'apellido_materno' , 'rut' , 'dv' , 'fnacimiento' , 'cestado_civil' , 'cdonante' , 'fsolicitud' , 'tobservaciones')
admin.site.register(Prog_solicitud , Prog_solicitud_Admin)