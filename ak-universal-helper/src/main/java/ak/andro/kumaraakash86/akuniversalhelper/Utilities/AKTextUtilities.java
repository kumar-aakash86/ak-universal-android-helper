package ak.andro.kumaraakash86.akuniversalhelper.Utilities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by AAKASH on 28-10-2016.
 */
public class AKTextUtilities {

    public static void setTypeFace(Context _context, View _parentView, int _id, String _fontName)
    {
        Typeface tf = Typeface.createFromAsset(_context.getAssets(), _fontName);

        View _view = _parentView.findViewById(_id);
        if(_view instanceof TextView)
        {
            TextView tv = (TextView) _view;
            tv.setTypeface(tf);
        }
        else if(_view instanceof EditText)
        {
            EditText et = (EditText)_view;
            et.setTypeface(tf);
        }
        else if(_view instanceof Button)
        {
            Button btn = (Button)_view;
            btn.setTypeface(tf);
        }
    }

    public static void setTypeFace(Activity _context, int _id, String _fontName)
    {
        Typeface tf = Typeface.createFromAsset(_context.getAssets(), _fontName);

        View _view = _context.findViewById(_id);
        if(_view instanceof TextView)
        {
            TextView tv = (TextView) _view;
            tv.setTypeface(tf);
        }
        else if(_view instanceof EditText)
        {
            EditText et = (EditText)_view;
            et.setTypeface(tf);
        }
        else if(_view instanceof Button)
        {
            Button btn = (Button)_view;
            btn.setTypeface(tf);
        }
    }


    public static void setTypeFace(Context _context, View _view, String _fontName)
    {
        Typeface tf = Typeface.createFromAsset(_context.getAssets(), _fontName);

        if(_view instanceof TextView)
        {
            TextView tv = (TextView) _view;
            tv.setTypeface(tf);
        }
        else if(_view instanceof EditText)
        {
            EditText et = (EditText)_view;
            et.setTypeface(tf);
        }
        else if(_view instanceof Button)
        {
            Button btn = (Button)_view;
            btn.setTypeface(tf);
        }
    }
}
