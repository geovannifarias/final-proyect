from dataclasses import fields
import email
import re
from shutil import register_archive_format
from socket import fromshare
from traceback import format_tb
from xml.sax.handler import property_declaration_handler
from django import forms
from django.core import validators
from App.models import reservas 
from django.forms.widgets import NumberInput

class Formreservas(forms.ModelForm):
    class Meta:
        model = reservas
        fields ='__all__'
#<----------opciones---------------------->
    ESTADOS =[('', '---'),('CONFIRMADA', 'Confirmada'),('RESERVADA', 'Reservada'), ('ANULADA','Anulada')]
#<----------Mis validadores---------------------->
    nombre =forms.CharField(validators=[
        validators.MinLengthValidator(5), 
        validators.MaxLengthValidator(30)])

    telefono=forms.CharField(required=False)
    FechaReserva = forms.DateField(widget=NumberInput(attrs={'type':'date'}),label='Fecha de reserva')
    horaReserva = forms.TimeField(widget=NumberInput(attrs={'type':'time'}),label='Hora de reserva')
    CantidadPersonas = forms.IntegerField()
    Estado = forms.ChoiceField(choices=ESTADOS)
    Observacion = forms.CharField(required=False, widget=forms.Textarea)
    website = forms.CharField()
    Email = forms.CharField(widget=forms.EmailInput)
    donante = forms.BooleanField()
    edad = forms.IntegerField()




 #<----------casillas del formulario---------------------->
    nombre.widget.attrs['class']='form-control'

    telefono.widget.attrs['class']='form-control'

    FechaReserva.widget.attrs['class']='form-control'

    horaReserva.widget.attrs['class']='form-control'

    CantidadPersonas.widget.attrs['class']='form-control'

    Estado.widget.attrs['class']='form-control'

    Observacion.widget.attrs['class']='form-control'

    website.widget.attrs['class']='form-control'

    Email.widget.attrs['class']='form-control'

    edad.widget.attrs['class']='form-control'