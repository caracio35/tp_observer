package observers.ejer_5.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.*;

import observers.ejer_5.model.observers.Observer;
import observers.ejer_5.model.restoran.Bebida;
import observers.ejer_5.model.restoran.ItemMenu;
import observers.ejer_5.model.restoran.Mesa;
import observers.ejer_5.model.restoran.Plato;
import observers.ejer_5.model.restoran.Restaurant;
import observers.ejer_5.model.tarjetas.TarComarcaPlus;
import observers.ejer_5.model.tarjetas.TarMaster;
import observers.ejer_5.model.tarjetas.TarViedma;
import observers.ejer_5.model.tarjetas.TarVisa;
import observers.ejer_5.model.tarjetas.Tarjeta;

public class RestoranUI extends Frame {
    private Restaurant restoran;

    public RestoranUI(Restaurant restoran) {
        this.restoran = restoran;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Restoran Manager");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // ComboBox para seleccionar mesas
        Choice mesaChoice = new Choice();
        for (Mesa mesa : restoran.getMesas()) {
            mesaChoice.add("Mesa " + mesa.getNumero());
        }
        add(mesaChoice);

        // ComboBox para seleccionar ítems del menú
        Choice itemChoice = new Choice();
        itemChoice.add("Coca Cola - 3500.5");
        itemChoice.add("Agua - 2500.5");
        itemChoice.add("Hamburguesa - 20000.0");
        itemChoice.add("Ensalada - 10000.5");
        add(itemChoice);

        // TextField para ingresar la propina
        TextField propinaField = new TextField(10);
        propinaField.setText("Propina");
        add(propinaField);

        // Botón para agregar ítem a la mesa seleccionada
        Button agregarItemButton = new Button("Agregar Ítem");
        agregarItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mesaIndex = mesaChoice.getSelectedIndex();
                String selectedItem = itemChoice.getSelectedItem();
                ItemMenu item = parseItem(selectedItem);
                restoran.agregarItem(item, mesaIndex);
            }
        });
        add(agregarItemButton);

        // Botón para pagar
        Button pagarButton = new Button("Pagar");
        pagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mesaIndex = mesaChoice.getSelectedIndex();
                double propina = Double.parseDouble(propinaField.getText());
                Tarjeta tarjeta = showTarjetaDialog();
                restoran.pagar(tarjeta, propina, mesaIndex);
            }
        });
        add(pagarButton);

        setVisible(true);
    }

    private ItemMenu parseItem(String itemDescription) {
        if (itemDescription.startsWith("Coca Cola")) {
            return new Bebida("Coca Cola", 3500.5);
        } else if (itemDescription.startsWith("Agua")) {
            return new Bebida("Agua", 2500.5);
        } else if (itemDescription.startsWith("Hamburguesa")) {
            return new Plato("Hamburguesa", "Carne con queso", 20000.0);
        } else if (itemDescription.startsWith("Ensalada")) {
            return new Plato("Ensalada", "Verduras frescas", 10000.5);
        }
        return null;
    }

    private Tarjeta showTarjetaDialog() {
        JDialog dialog = new JDialog(this, "Ingresar Tarjeta", true);
        dialog.setLayout(new GridLayout(6, 2));

        JLabel tipoLabel = new JLabel("Tipo de Tarjeta:");
        JComboBox<String> tipoComboBox = new JComboBox<>(new String[] { "Comarca Plus", "Master", "Visa", "Viedma" });
        JLabel numeroLabel = new JLabel("Número de Tarjeta:");
        JTextField numeroField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre del Propietario:");
        JTextField nombreField = new JTextField();
        JLabel limiteLabel = new JLabel("Límite de Crédito:");
        JTextField limiteField = new JTextField();
        JLabel fechaLabel = new JLabel("Fecha de Vencimiento (AAAA-MM-DD):");
        JTextField fechaField = new JTextField();

        dialog.add(tipoLabel);
        dialog.add(tipoComboBox);
        dialog.add(numeroLabel);
        dialog.add(numeroField);
        dialog.add(nombreLabel);
        dialog.add(nombreField);
        dialog.add(limiteLabel);
        dialog.add(limiteField);
        dialog.add(fechaLabel);
        dialog.add(fechaField);

        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(aceptarButton);

        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        try {
            int numTarjeta = Integer.parseInt(numeroField.getText());
            String nombrePropietario = nombreField.getText();
            double limiteCredito = Double.parseDouble(limiteField.getText());
            LocalDate fechaVencimiento = LocalDate.parse(fechaField.getText());

            String tipoTarjeta = (String) tipoComboBox.getSelectedItem();
            switch (tipoTarjeta) {
                case "Comarca Plus":
                    return new TarComarcaPlus(numTarjeta, nombrePropietario, limiteCredito, fechaVencimiento);
                case "Master":
                    return new TarMaster(numTarjeta, nombrePropietario, limiteCredito, fechaVencimiento);
                case "Visa":
                    return new TarVisa(numTarjeta, nombrePropietario, limiteCredito, fechaVencimiento);
                case "Viedma":
                    return new TarViedma(numTarjeta, nombrePropietario, limiteCredito, fechaVencimiento);
                default:
                    return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
