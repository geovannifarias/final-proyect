from django.contrib import admin

from .models import reservas

# Register your models here.

class proyectoAdmin(admin.ModelAdmin):
    list_display=['nombre',
                    'telefono',
                    'FechaReserva',
                    'horaReserva',
                    'CantidadPersonas',
                    'Estado',
                    'Observacion',
                    'website',
                    'Email',
                    'donante',
                    'edad'
                    ]

admin.site.register(reservas, proyectoAdmin)
