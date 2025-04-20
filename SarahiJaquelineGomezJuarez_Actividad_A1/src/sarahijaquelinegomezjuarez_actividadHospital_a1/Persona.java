/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sarahijaquelinegomezjuarez_actividadHospital_a1;

import javax.swing.JOptionPane;

public class Persona {
    // Atributos
    private double peso;
    private double estatura; // en metros
    private double imc;

    // Métodos Getter y Setter
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getImc() {
        return imc;
    }

    // Método para calcular el IMC
    public void calcularImc() {
        this.imc = peso / (estatura * estatura);
    }

    // Método para mostrar el IMC y su clasificación
    public void mostrarImc() {
        calcularImc(); // Actualiza el valor del IMC

        String clasificacion;
        if (imc < 18.5) {
            clasificacion = "Bajo peso";
        } else if (imc <= 24.9) {
            clasificacion = "Peso normal";
        } else if (imc <= 29.9) {
            clasificacion = "Sobrepeso";
        } else if (imc <= 34.9) {
            clasificacion = "Obesidad grado I";
        } else if (imc <= 39.9) {
            clasificacion = "Obesidad grado II";
        } else {
            clasificacion = "Obesidad grado III";
        }

        String mensaje = String.format("Tu IMC es: %.2f\nClasificación: %s", imc, clasificacion);
        JOptionPane.showMessageDialog(null, mensaje, "Resultado del IMC", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método principal (main)
    public static void main(String[] args) {
        Persona persona = new Persona();

        try {
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu peso en kilogramos:"));

            // entrada de metros y centímetros por separado
            int metros = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu estatura en metros (solo el número entero):")); // NUEVO
            int centimetros = Integer.parseInt(JOptionPane.showInputDialog("Ingresa los centímetros adicionales:")); // NUEVO

            // se convierte todo a metros
            double estaturaTotal = metros + (centimetros / 100.0); // MODIFICADO

            // ESTATURA TOTAL
            persona.setPeso(peso);
            persona.setEstatura(estaturaTotal); // MODIFICADO
            persona.mostrarImc();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida,Por favor ingresa valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
     }  
    }
     
    