from django.db import models

# Create your models here.
class reservas(models.Model):
    nombre =models.CharField(max_length=50)

    telefono=models.CharField(max_length=9)
    FechaReserva = models.DateField(db_column='FechaReserva')
    horaReserva = models.TimeField(db_column='horaReserva')
    CantidadPersonas = models.IntegerField()
    Estado = models.CharField(max_length=10)
    Observacion = models.CharField(max_length=150)
    website = models.CharField(max_length=100)
    Email = models.CharField(max_length=50)
    donante = models.BooleanField()
    edad = models.IntegerField()