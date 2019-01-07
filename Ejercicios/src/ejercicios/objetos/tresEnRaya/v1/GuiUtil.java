package ejercicios.objetos.tresEnRaya.v1;

import java.awt.BasicStroke;
import java.awt.Color;

public class GuiUtil {

	final static BasicStroke SIMPLE = new BasicStroke(1.0f);
	final static BasicStroke STROKE = new BasicStroke(2.0f);
    final static BasicStroke WIDE_STROKE = new BasicStroke(11.0f);
    final static float DASH1[] = {10.0f};
    final static BasicStroke DASHED = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, DASH1, 0.0f);
}
