# Generated by Django 4.1.1 on 2022-12-05 02:35

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Prog_estado_civil',
            fields=[
                ('cestado_civil', models.CharField(max_length=3, primary_key=True, serialize=False, unique=True)),
                ('estado_civil', models.CharField(choices=[('S', 'Soltero'), ('C', 'Casado'), ('D', 'Divorciado'), ('V', 'Viudo')], max_length=15)),
            ],
        ),
        migrations.CreateModel(
            name='Prog_tipo_solicitud',
            fields=[
                ('ctipo_solicitud', models.CharField(max_length=3, primary_key=True, serialize=False, unique=True)),
                ('tipo_solicitud', models.CharField(max_length=50)),
            ],
        ),
        migrations.CreateModel(
            name='Prog_solicitud',
            fields=[
                ('id_solicitud', models.AutoField(primary_key=True, serialize=False, unique=True)),
                ('nombres', models.CharField(max_length=50)),
                ('apellido_paterno', models.CharField(max_length=50, verbose_name='Apellido Paterno')),
                ('apellido_materno', models.CharField(max_length=50, verbose_name='Apellido Materno')),
                ('rut', models.IntegerField()),
                ('dv', models.CharField(max_length=1)),
                ('fnacimiento', models.DateField()),
                ('cdonante', models.BooleanField()),
                ('fsolicitud', models.DateField(auto_now_add=True)),
                ('tobservaciones', models.TextField(max_length=255)),
                ('cestado_civil', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='App.prog_estado_civil')),
                ('ctipo_solicitud', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='App.prog_tipo_solicitud')),
            ],
        ),
    ]