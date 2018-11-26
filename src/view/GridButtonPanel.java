package view;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import model.SpotButton;

public class GridButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpotButton A1, A2, A3, A4, A5, A6, A7, A8, A9, A10;
	private SpotButton B1, B2, B3, B4, B5, B6, B7, B8, B9, B10;
	private SpotButton C1, C2, C3, C4, C5, C6, C7, C8, C9, C10;
	private SpotButton D1, D2, D3, D4, D5, D6, D7, D8, D9, D10;
	private SpotButton E1, E2, E3, E4, E5, E6, E7, E8, E9, E10;
	private ArrayList<SpotButton> gridButtons;
	private Controller controller;

	public GridButtonPanel() {
		gridButtons = new ArrayList<SpotButton>();
		controller = new Controller();

		initButtons();

		setLayout(new GridLayout(5, 10));
		addButtonsToPanel();

		disableGridButtons();
	}

	public void addButtonsToPanel() {
		for (SpotButton sb : gridButtons) {
			if (sb != null) {
				this.add(sb);
			}

		}
	}

	public void enableGridButtons() {
		for (SpotButton sb : gridButtons) {
			if (sb != null) {
				sb.setEnabled(true);
			}

		}
	}

	public void disableGridButtons() {
		for (SpotButton sb : gridButtons) {
			if (sb != null) {
				sb.setEnabled(false);
			}

		}
	}

	public SpotButton getA1() {
		return A1;
	}

	public void setA1(SpotButton a1) {
		A1 = a1;
	}

	public SpotButton getA2() {
		return A2;
	}

	public void setA2(SpotButton a2) {
		A2 = a2;
	}

	public SpotButton getA3() {
		return A3;
	}

	public void setA3(SpotButton a3) {
		A3 = a3;
	}

	public SpotButton getA4() {
		return A4;
	}

	public void setA4(SpotButton a4) {
		A4 = a4;
	}

	public SpotButton getA5() {
		return A5;
	}

	public void setA5(SpotButton a5) {
		A5 = a5;
	}

	public SpotButton getA6() {
		return A6;
	}

	public void setA6(SpotButton a6) {
		A6 = a6;
	}

	public SpotButton getA7() {
		return A7;
	}

	public void setA7(SpotButton a7) {
		A7 = a7;
	}

	public SpotButton getA8() {
		return A8;
	}

	public void setA8(SpotButton a8) {
		A8 = a8;
	}

	public SpotButton getA9() {
		return A9;
	}

	public void setA9(SpotButton a9) {
		A9 = a9;
	}

	public SpotButton getA10() {
		return A10;
	}

	public void setA10(SpotButton a10) {
		A10 = a10;
	}

	public SpotButton getB1() {
		return B1;
	}

	public void setB1(SpotButton b1) {
		B1 = b1;
	}

	public SpotButton getB2() {
		return B2;
	}

	public void setB2(SpotButton b2) {
		B2 = b2;
	}

	public SpotButton getB3() {
		return B3;
	}

	public void setB3(SpotButton b3) {
		B3 = b3;
	}

	public SpotButton getB4() {
		return B4;
	}

	public void setB4(SpotButton b4) {
		B4 = b4;
	}

	public SpotButton getB5() {
		return B5;
	}

	public void setB5(SpotButton b5) {
		B5 = b5;
	}

	public SpotButton getB6() {
		return B6;
	}

	public void setB6(SpotButton b6) {
		B6 = b6;
	}

	public SpotButton getB7() {
		return B7;
	}

	public void setB7(SpotButton b7) {
		B7 = b7;
	}

	public SpotButton getB8() {
		return B8;
	}

	public void setB8(SpotButton b8) {
		B8 = b8;
	}

	public SpotButton getB9() {
		return B9;
	}

	public void setB9(SpotButton b9) {
		B9 = b9;
	}

	public SpotButton getB10() {
		return B10;
	}

	public void setB10(SpotButton b10) {
		B10 = b10;
	}

	public SpotButton getC1() {
		return C1;
	}

	public void setC1(SpotButton c1) {
		C1 = c1;
	}

	public SpotButton getC2() {
		return C2;
	}

	public void setC2(SpotButton c2) {
		C2 = c2;
	}

	public SpotButton getC3() {
		return C3;
	}

	public void setC3(SpotButton c3) {
		C3 = c3;
	}

	public SpotButton getC4() {
		return C4;
	}

	public void setC4(SpotButton c4) {
		C4 = c4;
	}

	public SpotButton getC5() {
		return C5;
	}

	public void setC5(SpotButton c5) {
		C5 = c5;
	}

	public SpotButton getC6() {
		return C6;
	}

	public void setC6(SpotButton c6) {
		C6 = c6;
	}

	public SpotButton getC7() {
		return C7;
	}

	public void setC7(SpotButton c7) {
		C7 = c7;
	}

	public SpotButton getC8() {
		return C8;
	}

	public void setC8(SpotButton c8) {
		C8 = c8;
	}

	public SpotButton getC9() {
		return C9;
	}

	public void setC9(SpotButton c9) {
		C9 = c9;
	}

	public SpotButton getC10() {
		return C10;
	}

	public void setC10(SpotButton c10) {
		C10 = c10;
	}

	public SpotButton getD1() {
		return D1;
	}

	public void setD1(SpotButton d1) {
		D1 = d1;
	}

	public SpotButton getD2() {
		return D2;
	}

	public void setD2(SpotButton d2) {
		D2 = d2;
	}

	public SpotButton getD3() {
		return D3;
	}

	public void setD3(SpotButton d3) {
		D3 = d3;
	}

	public SpotButton getD4() {
		return D4;
	}

	public void setD4(SpotButton d4) {
		D4 = d4;
	}

	public SpotButton getD5() {
		return D5;
	}

	public void setD5(SpotButton d5) {
		D5 = d5;
	}

	public SpotButton getD6() {
		return D6;
	}

	public void setD6(SpotButton d6) {
		D6 = d6;
	}

	public SpotButton getD7() {
		return D7;
	}

	public void setD7(SpotButton d7) {
		D7 = d7;
	}

	public SpotButton getD8() {
		return D8;
	}

	public void setD8(SpotButton d8) {
		D8 = d8;
	}

	public SpotButton getD9() {
		return D9;
	}

	public void setD9(SpotButton d9) {
		D9 = d9;
	}

	public SpotButton getD10() {
		return D10;
	}

	public void setD10(SpotButton d10) {
		D10 = d10;
	}

	public SpotButton getE1() {
		return E1;
	}

	public void setE1(SpotButton e1) {
		E1 = e1;
	}

	public SpotButton getE2() {
		return E2;
	}

	public void setE2(SpotButton e2) {
		E2 = e2;
	}

	public SpotButton getE3() {
		return E3;
	}

	public void setE3(SpotButton e3) {
		E3 = e3;
	}

	public SpotButton getE4() {
		return E4;
	}

	public void setE4(SpotButton e4) {
		E4 = e4;
	}

	public SpotButton getE5() {
		return E5;
	}

	public void setE5(SpotButton e5) {
		E5 = e5;
	}

	public SpotButton getE6() {
		return E6;
	}

	public void setE6(SpotButton e6) {
		E6 = e6;
	}

	public SpotButton getE7() {
		return E7;
	}

	public void setE7(SpotButton e7) {
		E7 = e7;
	}

	public SpotButton getE8() {
		return E8;
	}

	public void setE8(SpotButton e8) {
		E8 = e8;
	}

	public SpotButton getE9() {
		return E9;
	}

	public void setE9(SpotButton e9) {
		E9 = e9;
	}

	public SpotButton getE10() {
		return E10;
	}

	public void setE10(SpotButton e10) {
		E10 = e10;
	}

	public ArrayList<SpotButton> getGridButtons() {
		return gridButtons;
	}

	public void setGridButtons(ArrayList<SpotButton> gridButtons) {
		this.gridButtons = gridButtons;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void addZombie(int spotId) {
		for (SpotButton sb : gridButtons) {
			if (sb.getSpotButtonID() == spotId) {
				sb.addZombie();
			}
		}
	}

	public void initButtons() {
		A1 = new SpotButton();
		A2 = new SpotButton();
		A3 = new SpotButton();
		A4 = new SpotButton();
		A5 = new SpotButton();
		A6 = new SpotButton();
		A7 = new SpotButton();
		A8 = new SpotButton();
		A9 = new SpotButton();
		A10 = new SpotButton();

		gridButtons.add(A1);
		gridButtons.add(A2);
		gridButtons.add(A3);
		gridButtons.add(A4);
		gridButtons.add(A5);
		gridButtons.add(A6);
		gridButtons.add(A6);
		gridButtons.add(A7);
		gridButtons.add(A8);
		gridButtons.add(A9);
		gridButtons.add(A10);

		B1 = new SpotButton();
		B2 = new SpotButton();
		B3 = new SpotButton();
		B4 = new SpotButton();
		B5 = new SpotButton();
		B6 = new SpotButton();
		B7 = new SpotButton();
		B8 = new SpotButton();
		B9 = new SpotButton();
		B10 = new SpotButton();

		gridButtons.add(B1);
		gridButtons.add(B2);
		gridButtons.add(B3);
		gridButtons.add(B4);
		gridButtons.add(B5);
		gridButtons.add(B6);
		gridButtons.add(B6);
		gridButtons.add(B7);
		gridButtons.add(B8);
		gridButtons.add(B9);
		gridButtons.add(B10);

		C1 = new SpotButton();
		C2 = new SpotButton();
		C3 = new SpotButton();
		C4 = new SpotButton();
		C5 = new SpotButton();
		C6 = new SpotButton();
		C7 = new SpotButton();
		C8 = new SpotButton();
		C9 = new SpotButton();
		C10 = new SpotButton();

		gridButtons.add(C1);
		gridButtons.add(C2);
		gridButtons.add(C3);
		gridButtons.add(C4);
		gridButtons.add(C5);
		gridButtons.add(C6);
		gridButtons.add(C6);
		gridButtons.add(C7);
		gridButtons.add(C8);
		gridButtons.add(C9);
		gridButtons.add(C10);

		D1 = new SpotButton();
		D2 = new SpotButton();
		D3 = new SpotButton();
		D4 = new SpotButton();
		D5 = new SpotButton();
		D6 = new SpotButton();
		D7 = new SpotButton();
		D8 = new SpotButton();
		D9 = new SpotButton();
		D10 = new SpotButton();

		gridButtons.add(D1);
		gridButtons.add(D2);
		gridButtons.add(D3);
		gridButtons.add(D4);
		gridButtons.add(D5);
		gridButtons.add(D6);
		gridButtons.add(D6);
		gridButtons.add(D7);
		gridButtons.add(D8);
		gridButtons.add(D9);
		gridButtons.add(D10);

		E1 = new SpotButton();
		E2 = new SpotButton();
		E3 = new SpotButton();
		E4 = new SpotButton();
		E5 = new SpotButton();
		E6 = new SpotButton();
		E7 = new SpotButton();
		E8 = new SpotButton();
		E9 = new SpotButton();
		E10 = new SpotButton();

		gridButtons.add(E1);
		gridButtons.add(E2);
		gridButtons.add(E3);
		gridButtons.add(E4);
		gridButtons.add(E5);
		gridButtons.add(E6);
		gridButtons.add(E6);
		gridButtons.add(E7);
		gridButtons.add(E8);
		gridButtons.add(E9);
		gridButtons.add(E10);

	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}
}
