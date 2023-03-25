package Conversor;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Multi_Conversor {
	public static void main(String[] args) throws Exception {
		Boolean continueProgram = Boolean.TRUE;

		while (continueProgram) {

			Object[] options = { "Convertir Divisa", "Convertir Temperatura", "Salir" };
			String choice = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de Conversor", "Conversor",
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			Integer selectedOption = 0;
			String[] splitChoice = null;
			Boolean continueMoney = Boolean.FALSE;
			Boolean continueTemp = Boolean.FALSE;
			Boolean exit = Boolean.FALSE;
			if (choice == null || choice == "") {
				selectedOption = 3;
				exit = Boolean.TRUE;
			} else {
				splitChoice = choice.split(" ");
				if (splitChoice[1].equals("Divisa")) {
					selectedOption = 0;
					continueMoney = Boolean.TRUE;
				}

				if (splitChoice[1].equals("Temperatura")) {
					selectedOption = 1;
					continueTemp = Boolean.TRUE;

				if (splitChoice[1].equals("Salir")) {
					selectedOption = 3;
					exit = Boolean.TRUE;
				}

			}

			switch (selectedOption) {

			case 0: {

				DecimalFormat decimalFormat = new DecimalFormat("#.##");

				while (continueMoney) {

					String[] divisas = { "Pesos Arg a Dolar", "Pesos Arg a Euro", "Pesos Arg a Libras Esterlinas", "Pesos Arg a Yen Japonés", "Pesos Arg a Won sul-coreano",
							"Dolar a Pesos Arg", "Euro a Pesos Arg", "Libras Esterlinas a Pesos Arg", "Yen Japonés a Pesos Arg", "Won sul-coreano a Pesos Arg" };
					String optionMoney = (String) JOptionPane.showInputDialog(null, "Seleccione un tipo de cambio: ",
							"Conversor de Divisa", JOptionPane.QUESTION_MESSAGE, null, divisas, divisas[0]);

					if (optionMoney == null || optionMoney == "") {
						continueMoney = Boolean.FALSE;
					} else {
						String input = JOptionPane.showInputDialog(null, "Ingrese la cantidad a Convertir:");
						double dinero = 0;

						try {
							if (input != null) {
								dinero = Double.parseDouble(input);
								double resultado = 0;

								String[] moneis = optionMoney.split(" a ");
								String moneyFrom = moneis[0].trim();
								String moneyTo = moneis[1].trim();

								double valueDolar = (380);
								double valueEuro = (295);
								double valueLibra = (251);
								double valueYen = (1.58);
								double valueWon = (6.31);
								double value = 0;

								if (moneyFrom.equals("Pesos Arg")) {
									if (moneyTo.equals("Dolar"))
										value = valueDolar;
									if (moneyTo.equals("Euro"))
										value = valueEuro;
									if (moneyTo.equals("Libra Esterlinas"))
										value = valueLibra;
									if (moneyTo.equals("Yen Japonés"))
										value = valueYen;
									if (moneyTo.equals("Won sul-coreano"))
										value = valueWon;
									resultado = dinero / value;
								} else {
									if (moneyFrom.equals("Dolar"))
										value = valueDolar;
									if (moneyFrom.equals("Euro"))
										value = valueEuro;
									if (moneyFrom.equals("Libra Esterlinas"))
										value = valueLibra;
									if (moneyFrom.equals("Yen Japonés"))
										value = valueYen;
									if (moneyFrom.equals("Won sul-coreano"))
										value = valueWon;
									resultado = dinero * value;
								}

								JOptionPane.showMessageDialog(null, dinero + " " + moneyFrom + " son: "
										+ decimalFormat.format(resultado) + " " + moneyTo);

								Integer goAhead = JOptionPane.showConfirmDialog(null, "¿Desea seguir en monedas?", "",
										JOptionPane.YES_NO_OPTION);

								if (goAhead == JOptionPane.NO_OPTION) {
									continueMoney = Boolean.FALSE;
								}
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
						}

					}

				}
			}

			case 1: {

				while (continueTemp) {

					String[] grados = { "C° Celsius a Fahrenheit", "F° Fahrenheit a Celsius" };
					Integer optionTemp = JOptionPane.showOptionDialog(null, "Elija una opción: ",
							"Conversor de Temperatura", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							grados, grados[0]);
					if (optionTemp == null || optionTemp == -1) {
						continueTemp = Boolean.FALSE;
					} else {
						String valorNominal = JOptionPane.showInputDialog(null, "Ingrese Temperatura a Convertir");
						double valor = 0;
						try {
							if (valorNominal != null) {
								valor = (Double.parseDouble(valorNominal));
								double resultado = 0;

								if (optionTemp == 0) {
									resultado = (valor * 9 / 5) + 32;
									JOptionPane.showMessageDialog(null,
											valor + " Grados Celsius son: " + resultado + " Grados Fahrenheit");
								} else if (optionTemp == 1) {
									resultado = (valor - 32) * 5 / 9;
									JOptionPane.showMessageDialog(null,
											valor + " Grados Fahrenheit son: " + resultado + " Grados Celsius");
								}

								Integer goAhead = JOptionPane.showConfirmDialog(null, "¿Desea seguir en temperatura?",
										"", JOptionPane.YES_NO_OPTION);

								if (goAhead == JOptionPane.NO_OPTION) {
									continueTemp = Boolean.FALSE;
								}
							}

						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
						}

					}
				}
			}

			case 2: {
				if (exit) {
					JOptionPane.showMessageDialog(null, "Programa Cerrado");
					System.exit(0);
					break;
				}
			}
			}

		}
	}
}
}