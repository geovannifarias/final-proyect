
from django import forms
from App.models import *
from django.core import validators
from App.models import Prog_solicitud


class FormSolicitud(forms.ModelForm):
#<----------validadores---------------------->
    nombres=forms.CharField(validators=[validators.MinLengthValidator(4),validators.MaxLengthValidator(15)])
    apellido_paterno=forms.CharField(label='Apellido Paterno',
    validators=[validators.MinLengthValidator(5),validators.MaxLengthValidator(10)])
    apellido_materno=forms.CharField(label='Apellido Materno',
    validators=[validators.MinLengthValidator(5),validators.MaxLengthValidator(10)])
    rut=forms.IntegerField(label='Rut')
    dv= forms.CharField()

    class Meta:
        model= Prog_solicitud
        fields='__all__'


    fnacimiento= forms.DateField(label='fecha de Nacimiento',widget=forms.widgets.DateInput(attrs={'type': 'date'}))
    #fsolicitud=forms.DateField(label='fecha de Solicitud',widget=forms.widgets.DateInput(attrs={'type': 'date'}))
    tobservaciones=forms.CharField(widget=forms.Textarea)



 #<----------casillas del formulario---------------------->

    #id_solicitud.widget.attrs['class']='form-select'
    #ctipo_solicitud.widget.attrs['class']='form-control'
    nombres.widget.attrs['class']='form-control'
    apellido_paterno.widget.attrs['class']='form-control'
    apellido_materno.widget.attrs['class']='form-control'
    rut.widget.attrs['class']='form-control'
    dv.widget.attrs['class']='form-control'
    fnacimiento.widget.attrs['class']='form-control'
    #cestado_civil.widget.attrs['class']='form-control'
    #cdonante.widget.attrs['class']='form-control'
    #fsolicitud.widget.attrs['class']='form-control'
    tobservaciones.widget.attrs['class']='form-control'

