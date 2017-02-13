package koti.customviewexample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by User on 2/9/2017.
 */

public class TimeView extends TextView {

    private String titleText;
    private boolean color;

    public TimeView(Context context) {
        super(context);
        setTimeView();
    }


    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TimeView);
        int count = typedArray.getIndexCount();
        try {
            for (int i = 0; i< count; i++){
                int attr = typedArray.getIndex(i);
                if (attr== R.styleable.TimeView_title){
                    titleText = typedArray.getString(attr);
                    setTimeView();
                }else  if (attr == R.styleable.TimeView_setcolor){
                    color = typedArray.getBoolean(attr,false);
                    decorateText();
                }
            }
        }
        finally {
            typedArray.recycle();
        }
    }

    public TimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTimeView();
    }
    private void setTimeView(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm.aa");
        String time = dateFormat.format(Calendar.getInstance().getTime());

        if(this.titleText != null )
            setText(this.titleText+" "+time);
        else
            setText(time);

    }
    private void decorateText() {
        if(this.color == true){
            setShadowLayer(4, 2, 2, Color.rgb(250, 00, 250));
            setBackgroundColor(Color.CYAN);
        } else {
            setBackgroundColor(Color.RED);
        }
    }
}

