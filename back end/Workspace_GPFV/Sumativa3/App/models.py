from django.db import models

# Create your models here.

#creacion de clases

class Prog_tipo_solicitud(models.Model):
    ctipo_solicitud=models.CharField(primary_key=True,unique=True,max_length=3)
    tipo_solicitud=models.CharField(max_length=50,null=False)

    def __str__(self):
        return self.ctipo_solicitud


class Prog_estado_civil(models.Model):
    cestado_civil=models.CharField(primary_key=True,unique=True,max_length=3)
    Estado=(
        ('S','Soltero'),
        ('C','Casado'),
        ('D','Divorciado'),
        ('V','Viudo'),
    )
    estado_civil=models.CharField(max_length=15,choices=Estado)

    def __str__(self):
        return self.cestado_civil

class Prog_solicitud(models.Model):
    #codigo de id esta por defecto
    id_solicitud=models.AutoField(primary_key=True,unique=True)
    ctipo_solicitud =models.ForeignKey(Prog_tipo_solicitud, on_delete=models.CASCADE) #llave
    nombres=models.CharField(max_length=50)
    apellido_paterno=models.CharField(max_length=50,verbose_name='Apellido Paterno')
    apellido_materno=models.CharField(max_length=50,verbose_name='Apellido Materno')
    rut=models.IntegerField()##
    dv=models.CharField(max_length=1) #
    fnacimiento=models.DateField()
    cestado_civil=models.ForeignKey(Prog_estado_civil, on_delete=models.CASCADE) #llave 
    cdonante=models.BooleanField()#
    fsolicitud=models.DateField(auto_now_add=True)#
    tobservaciones=models.TextField(max_length=255)
    
















#rut digito verificador
#def digito_verificador(rut):
 #   reversed_digits = map(int, reversed(str(rut)))
  #  factors = cycle(range(2, 8))
   # s = sum(d * f for d, f in zip(reversed_digits, factors))
    #return (-s) % 11
