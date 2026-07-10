/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robertpalmer
 */
public class ColorConverter {

    public static Color stringToColor(String colorString) {
        try {
            // Check for predefined color names
            Color predefinedColor;
            try {
                Field field = Color.class.getField(colorString);
                predefinedColor = (Color) field.get(null);

                if (predefinedColor != null) {
                    return predefinedColor;
                }
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(ColorConverter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(ColorConverter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(ColorConverter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ColorConverter.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Check for hex color codes
            if (colorString.startsWith("#") && (colorString.length() == 7 || colorString.length() == 9)) {
                int r = Integer.parseInt(colorString.substring(1, 3), 16);
                int g = Integer.parseInt(colorString.substring(3, 5), 16);
                int b = Integer.parseInt(colorString.substring(5, 7), 16);
                int a = (colorString.length() == 9) ? Integer.parseInt(colorString.substring(7, 9), 16) : 255;
                return new Color(r, g, b, a);
            }

            // Check for RGB or RGBA strings
            if (colorString.startsWith("rgb(") || colorString.startsWith("rgba(")) {
                String[] components = colorString.substring(colorString.indexOf("(") + 1, colorString.indexOf(")")).split(",");
                int r = Integer.parseInt(components[0].trim());
                int g = Integer.parseInt(components[1].trim());
                int b = Integer.parseInt(components[2].trim());
                int a = (components.length == 4) ? Integer.parseInt(components[3].trim()) : 255;
                return new Color(r, g, b, a);
            }

        } catch (NumberFormatException e) {
            // Handle invalid color format
            return null;
        }

        // Invalid color format
        return null;
    }
}
