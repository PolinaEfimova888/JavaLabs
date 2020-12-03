package com.example.graphic;

        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Rect;
        import android.util.AttributeSet;
        import android.view.MotionEvent;
        import android.view.View;
        import androidx.annotation.Nullable;
        
class Rectang {
    int color,left,right,up,bottom;
    Rectang(int l, int u, int r, int b, int c) {
        color = c;
        right = r;
        bottom = b;
    }

    int getColor() {
        return color;
    }

    void setColor(int c) {
        color = c;
    }
}
public class MyView extends View{
    boolean flag = true;
    int width, height;
    Rectang[][] box = new Rectang[4][4];
    int blueColor = Color.BLUE;
    int RedColor = Color.RED;

//    public MyView(Context context) {
////        super(context);
////    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        width = canvas.getWidth();
        height = canvas.getHeight();
        int xsize = width / 4;
        int ysize = height / 4;

        Paint blue = new Paint();
        blue.setColor(RedColor);

//        Paint p = new Paint();
//        p.setColor(Color.GREEN);

        Paint red = new Paint();
        red.setColor(blueColor);

        blue.setStyle(Paint.Style.FILL);
        red.setStyle(Paint.Style.FILL);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                int left = j * xsize;
                int up = i * ysize;
                int right = left + xsize;
                int bottom = up + ysize;

                Rect rectang = new Rect();

                rectang.set(left + 4, up + 4, right - 4, bottom - 4);

                int color;

                if (flag) {
                    if (Math.random() > 0.5) {
                        canvas.drawRect(rectang, blue);
                        color = 1;
                    } else {
                        canvas.drawRect(rectang, red);
                        color = 0;
                    }

                    box[i][j] = new Rectang(left, up, right, bottom, color);

                } else {
                    color = box[i][j].getColor();
                    if (color == 0) {
                        canvas.drawRect(rectang, blue);
                        color = 1;
                    } else {
                        canvas.drawRect(rectang, red);
                        color = 0;
                    }
                }
            }
        }

        if (flag) flag = false;

        super.onDraw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    if (box[i][j].left < x && box[i][j].right > x &&
                            box[i][j].up < y && box[i][j].bottom > y) {

                        int k = i, m = j;

                        for (int ii = 0; ii < 4; ii++) {
                            for (int jj = 0; jj < 4; jj++) {
                                if (ii == k || jj == m) {
                                    if (box[ii][jj].getColor() == 1)
                                        box[ii][jj].setColor(0);
                                    else
                                        box[ii][jj].setColor(1);
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        invalidate();
        return true;
    }

}

