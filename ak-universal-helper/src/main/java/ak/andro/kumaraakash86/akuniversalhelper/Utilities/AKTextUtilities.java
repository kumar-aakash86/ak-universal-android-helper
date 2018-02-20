package ak.andro.kumaraakash86.akuniversalhelper.Utilities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ak.andro.kumaraakash86.akuniversalhelper.Listeners.click.TextClicker;
import ak.andro.kumaraakash86.akuniversalhelper.Log.AKLogFunctions;
import ak.andro.kumaraakash86.akuniversalhelper.core.AKUniversalConfiguration;
import ak.andro.kumaraakash86.akuniversalhelper.core.AKUniversalHelper;

/**
 * Created by AAKASH on 28-10-2016.
 */
public class AKTextUtilities {

    public static void setTypeFace(Activity _activity, View _parentView, String _fontName, int _id)
    {
        Typeface tf = Typeface.createFromAsset(_activity.getAssets(), AKUniversalHelper.getInstance().getFontDirectory()+_fontName);

        View _view = _parentView.findViewById(_id);
        if(_view instanceof EditText)
        {
            EditText et = (EditText)_view;
            et.setTypeface(tf);
        }
        else if(_view instanceof Button)
        {
            Button btn = (Button)_view;
            btn.setTypeface(tf);
        }
        else if(_view instanceof TextView)
        {
            TextView tv = (TextView) _view;
            tv.setTypeface(tf);
        }
        else{
            AKLogFunctions.ErrorMessage(_activity.getClass(), "setTypeface Error", "View is not a text container");
        }
    }

    public static void setTypeFace(Activity _activity, String _fontName, int _id)
    {
        Typeface tf = Typeface.createFromAsset(_activity.getAssets(), AKUniversalHelper.getInstance().getFontDirectory()+_fontName);

        View _view = _activity.findViewById(_id);
        if(_view instanceof EditText)
        {
            EditText et = (EditText)_view;
            et.setTypeface(tf);
        }
        else if(_view instanceof Button)
        {
            Button btn = (Button)_view;
            btn.setTypeface(tf);
        }
        else if(_view instanceof TextView)
        {
            TextView tv = (TextView) _view;
            tv.setTypeface(tf);
        }
        else{
            AKLogFunctions.ErrorMessage(_activity.getClass(), "setTypeface Error", "View "+_id+" is not a text container");
        }
    }


    public static void setTypeFace(Activity _activity, String _fontName, View _view)
    {
        Typeface tf = Typeface.createFromAsset(_activity.getAssets(), AKUniversalHelper.getInstance().getFontDirectory()+_fontName);

        if(_view instanceof EditText)
        {
            EditText et = (EditText)_view;
            et.setTypeface(tf);
        }
        else if(_view instanceof Button)
        {
            Button btn = (Button)_view;
            btn.setTypeface(tf);
        }
        else if(_view instanceof TextView)
        {
            TextView tv = (TextView) _view;
            tv.setTypeface(tf);
        }
        else{
            AKLogFunctions.ErrorMessage(_activity.getClass(), "setTypeface Error", "View "+_view+" is not a text container");
        }
    }

    public static void setTypeFace(Activity _activity, String _fontName, int... _id)
    {
        Typeface tf = Typeface.createFromAsset(_activity.getAssets(), AKUniversalHelper.getInstance().getFontDirectory()+_fontName);

        for (int id: _id) {
            setTypeFace(_activity, _fontName, id);
        }
    }

    public static void setTypeFace(Activity _activity, String _fontName, View... _view)
    {
        Typeface tf = Typeface.createFromAsset(_activity.getAssets(), AKUniversalHelper.getInstance().getFontDirectory()+_fontName);

        for (View view: _view) {
            setTypeFace(_activity, _fontName, view);
        }
    }



    public static class TextStyler{
        private String fullText;
        private SpannableString spannableString;
        String[] overlookItems;
        Boolean matchExact=false;
        Boolean linkUnderline=true;
        int linkColor= Color.BLUE;

        public TextStyler Init(@NonNull String _fullText){
            fullText = _fullText;
            spannableString = new SpannableString(_fullText);
            return this;
        }

        //region OVERLOOK
        /**
         * OVERLOOK THESE STRINGS
         * @param _overlook OVERLOOK THESE
         */
        public TextStyler setOverlookItems(@Nullable String[] _overlook){
            this.overlookItems = _overlook;
            return this;
        }

        private String overLook(String _text)
        {
            if(this.overlookItems != null) {
                for (String item : this.overlookItems) {
                    if(_text.contains(item))
                        _text = _text.replace(item, "");
                }
            }
            return _text;
        }
        //endregion

        //region MATCH EXACLTY
        /**
         * OVERLOOK THESE STRINGS
         * @param _exact MATCH TEXT EXACTLY
         */
        public TextStyler doMatchExactly(boolean _exact){
            this.matchExact = _exact;
            return this;
        }
        //endregion

        //region UNDERLINE
        /**
         *  GENERATE UNDERLINE TEXT
         * @param _textToStyle TEXT TO STYLE
         */
        public TextStyler setUnderline(@NonNull String... _textToStyle){
            int startIndex = 0;
            int endIndex;

            if(!this.matchExact)
            {
                for (String text : _textToStyle) {
                    endIndex=0;
                    while(fullText.indexOf(text, endIndex) > -1)
                    {
                        startIndex = fullText.indexOf(overLook(text), endIndex);
                        endIndex = startIndex + text.length();
                        spannableString.setSpan(new UnderlineSpan(), startIndex, endIndex, 0);
                    }
                }
            }
            else {
                String[] textArray = fullText.split(" ");
                for (String item : textArray) {
                    endIndex = startIndex + item.length();
                    for (String text : _textToStyle) {
                        if (overLook(item).equals(text)) {
                            spannableString.setSpan(new UnderlineSpan(), startIndex, endIndex, 0);
                        }
                    }
                    startIndex = endIndex + 1;
                }
            }
            return this;
        }
        //endregion

        //region BOLD
        /**
         * GENERATE BOLD TEXT
         * @param _textToStyle TEXT TO STYLE
         */
        public TextStyler setBold(@NonNull String... _textToStyle){
            int startIndex = 0;
            int endIndex;

            if(!this.matchExact)
            {
                for (String text : _textToStyle) {
                    endIndex=0;
                    while(fullText.indexOf(text, endIndex) > -1)
                    {
                        startIndex = fullText.indexOf(overLook(text), endIndex);
                        endIndex = startIndex + text.length();
                        spannableString.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, 0);
                    }
                }
            }
            else {
                String[] textArray = fullText.split(" ");
                for (String item : textArray) {
                    endIndex = startIndex + item.length();
                    for (String text : _textToStyle) {
                        if (item.equals(text)) {
                            spannableString.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, 0);
                        }
                    }
                    startIndex = endIndex + 1;
                }
            }
            return this;
        }
        //endregion

        //region ITALIC
        /**
         *  GENERATE ITALIC TEXT
         * @param _textToStyle TEXT TO STYLE
         */
        public TextStyler setItalic(@NonNull String... _textToStyle){
            int startIndex = 0;
            int endIndex;

            if(!this.matchExact)
            {
                for (String text : _textToStyle) {
                    endIndex=0;
                    while(fullText.indexOf(text, endIndex) > -1)
                    {
                        startIndex = fullText.indexOf(overLook(text), endIndex);
                        endIndex = startIndex + text.length();
                        spannableString.setSpan(new StyleSpan(Typeface.ITALIC), startIndex, endIndex, 0);
                    }
                }
            }
            else {
                String[] textArray = fullText.split(" ");
                for (String item : textArray) {
                    endIndex = startIndex + item.length();
                    for (String text : _textToStyle) {
                        if (item.equals(text)) {
                            spannableString.setSpan(new StyleSpan(Typeface.ITALIC), startIndex, endIndex, 0);
                        }
                    }
                    startIndex = endIndex + 1;
                }
            }
            return this;
        }
        //endregion

        //region RESIZE
        /**
         *  RESIZE TEXT RELATIVELY OF FONT SIZE
         * @param _textToStyle TEXT TO STYLE
         */
        public TextStyler setSize(float _targetSize, @NonNull String... _textToStyle ){
            int startIndex = 0;
            int endIndex;

            if(!this.matchExact)
            {
                for (String text : _textToStyle) {
                    endIndex=0;
                    while(fullText.indexOf(text, endIndex) > -1)
                    {
                        startIndex = fullText.indexOf(overLook(text), endIndex);
                        endIndex = startIndex + text.length();
                        spannableString.setSpan(new RelativeSizeSpan(_targetSize), startIndex, endIndex, 0);
                    }
                }
            }
            else {
                String[] textArray = fullText.split(" ");
                for (String item : textArray) {
                    endIndex = startIndex + item.length();
                    for (String text : _textToStyle) {
                        if (item.equals(text)) {
                            spannableString.setSpan(new RelativeSizeSpan(_targetSize), startIndex, endIndex, 0);
                        }
                    }
                    startIndex = endIndex + 1;
                }
            }
            return  this;
        }
        //endregion

        //region STRIKETHROUGH
        /**
         *  SET TEXT STRIKETHROUGH
         * @param _textToStyle TEXT TO STYLE
         */
        public TextStyler setStrikethrough(@NonNull String... _textToStyle ){
            int startIndex = 0;
            int endIndex;

            if(!this.matchExact)
            {
                for (String text : _textToStyle) {
                    endIndex=0;
                    while(fullText.indexOf(text, endIndex) > -1)
                    {
                        startIndex = fullText.indexOf(overLook(text), endIndex);
                        endIndex = startIndex + text.length();
                        spannableString.setSpan(new StrikethroughSpan(), startIndex, endIndex, 0);
                    }
                }
            }
            else {
                String[] textArray = fullText.split(" ");
                for (String item : textArray) {
                    endIndex = startIndex + item.length();
                    for (String text : _textToStyle) {
                        if (item.equals(text)) {
                            spannableString.setSpan(new StrikethroughSpan(), startIndex, endIndex, 0);
                        }
                    }
                    startIndex = endIndex + 1;
                }
            }
            return this;
        }
        //endregion

        //region SUPERSCRIPT
        /**
         *  SET TEXT SUPERSCRIPT
         * @param _textToStyle TEXT TO STYLE
         */
        public TextStyler setSuperscript(@NonNull String... _textToStyle ){
            int startIndex = 0;
            int endIndex;

            if(!this.matchExact)
            {
                for (String text : _textToStyle) {
                    endIndex=0;
                    while(fullText.indexOf(text, endIndex) > -1)
                    {
                        startIndex = fullText.indexOf(overLook(text), endIndex);
                        endIndex = startIndex + text.length();
                        spannableString.setSpan(new SuperscriptSpan(), startIndex, endIndex, 0);
                    }
                }
            }
            else {
                String[] textArray = fullText.split(" ");
                for (String item : textArray) {
                    endIndex = startIndex + item.length();
                    for (String text : _textToStyle) {
                        if (item.equals(text)) {
                            spannableString.setSpan(new SuperscriptSpan(), startIndex, endIndex, 0);
                        }
                    }
                    startIndex = endIndex + 1;
                }
            }
            return this;
        }
        //endregion

        //region SUBSCRIPT
        /**
         *  SET TEXT SUBSCRIPT
         * @param _textToStyle TEXT TO STYLE
         */
        public TextStyler setSubscript(@NonNull String... _textToStyle ){
            int startIndex = 0;
            int endIndex;

            if(!this.matchExact)
            {
                for (String text : _textToStyle) {
                    endIndex=0;
                    while(fullText.indexOf(text, endIndex) > -1)
                    {
                        startIndex = fullText.indexOf(overLook(text), endIndex);
                        endIndex = startIndex + text.length();
                        spannableString.setSpan(new SubscriptSpan(), startIndex, endIndex, 0);
                    }
                }
            }
            else {
                String[] textArray = fullText.split(" ");
                for (String item : textArray) {
                    endIndex = startIndex + item.length();
                    for (String text : _textToStyle) {
                        if (item.equals(text)) {
                            spannableString.setSpan(new SubscriptSpan(), startIndex, endIndex, 0);
                        }
                    }
                    startIndex = endIndex + 1;
                }
            }
            return this;
        }
        //endregion

        //region TEXT COLOR
        /**
         *  SET TEXT COLOR
         * @param _textToStyle TEXT TO STYLE
         */
        public TextStyler setColor(int _color, @NonNull String... _textToStyle ){
            int startIndex = 0;
            int endIndex;

            if(!this.matchExact)
            {
                for (String text : _textToStyle) {
                    endIndex=0;
                    while(fullText.indexOf(text, endIndex) > -1)
                    {
                        startIndex = fullText.indexOf(overLook(text), endIndex);
                        endIndex = startIndex + text.length();
                        spannableString.setSpan(new ForegroundColorSpan(_color), startIndex, endIndex, 0);
                    }
                }
            }
            else {
                String[] textArray = fullText.split(" ");
                for (String item : textArray) {
                    endIndex = startIndex + item.length();
                    for (String text : _textToStyle) {
                        if (item.equals(text)) {
                            spannableString.setSpan(new ForegroundColorSpan(_color), startIndex, endIndex, 0);
                        }
                    }
                    startIndex = endIndex + 1;
                }
            }
            return this;
        }
        //endregion

        //region TEXT BACKGROUND COLOR
        /**
         *  SET TEXT BACKGROUND COLOR
         * @param _textToStyle TEXT TO STYLE
         */
        public TextStyler setBGColor(int _color, @NonNull String... _textToStyle ){
            int startIndex = 0;
            int endIndex;

            if(!this.matchExact)
            {
                for (String text : _textToStyle) {
                    endIndex=0;
                    while(fullText.indexOf(text, endIndex) > -1)
                    {
                        startIndex = fullText.indexOf(overLook(text), endIndex);
                        endIndex = startIndex + text.length();
                        spannableString.setSpan(new BackgroundColorSpan(_color), startIndex, endIndex, 0);
                    }
                }
            }
            else {
                String[] textArray = fullText.split(" ");
                for (String item : textArray) {
                    endIndex = startIndex + item.length();
                    for (String text : _textToStyle) {
                        if (item.equals(text)) {
                            spannableString.setSpan(new BackgroundColorSpan(_color), startIndex, endIndex, 0);
                        }
                    }
                    startIndex = endIndex + 1;
                }
            }
            return this;
        }
        //endregion

        //region CLICK EVENT
        /**
         *  SET TEXT SUBSCRIPT
         * @param _textToStyle TEXT TO STYLE
         */
        public void setClickListener(@NonNull final TextClicker _textClicker, @NonNull String... _textToStyle ){
            int startIndex = 0;
            int endIndex;
            if(!this.matchExact)
            {
                for (String text : _textToStyle) {
                    endIndex=0;
                    while(fullText.indexOf(text, endIndex) > -1)
                    {
                        startIndex = fullText.indexOf(overLook(text), endIndex);
                        endIndex = startIndex + text.length();
                        spannableString.setSpan(new ClickableSpan() {
                            @Override
                            public void onClick(View widget) {
                                TextView tv = (TextView) widget;
                                Spanned text = (Spanned)tv.getText();
                                _textClicker.TextClicked(tv, text.subSequence(text.getSpanStart(this), text.getSpanEnd(this)));
                            }

                            @Override
                            public void updateDrawState(TextPaint ds) {
                                ds.setUnderlineText(linkUnderline);
                                ds.setColor(linkColor);
                            }
                        }, startIndex, endIndex, 0);
                    }
                }
            }
            else {
                String[] textArray = fullText.split(" ");
                for (String item : textArray) {
                    endIndex = startIndex + item.length();
                    for (String text : _textToStyle) {
                        if (item.equals(text)) {
                            spannableString.setSpan(new ClickableSpan() {
                                @Override
                                public void onClick(View widget) {
                                    TextView tv = (TextView) widget;
                                    Spanned text = (Spanned)tv.getText();
                                    _textClicker.TextClicked(tv, text.subSequence(text.getSpanStart(this), text.getSpanEnd(this)));
                                }

                                @Override
                                public void updateDrawState(TextPaint ds) {
                                    ds.setUnderlineText(linkUnderline);
                                    ds.setColor(linkColor);
                                }
                            }, startIndex, endIndex, 0);
                        }
                    }
                    startIndex = endIndex + 1;
                }
            }
        }

        public TextStyler setLinkUnderline(boolean _showUnderline)
        {
            this.linkUnderline = _showUnderline;
            return this;
        }
        public TextStyler setLinkColor(int _color)
        {
            this.linkColor = _color;
            return this;
        }
        //endregion

        //region APPLY STYLE
        /**
         * APPLY STYLE ON TEXTVIEW
         * @param _textview TEXTVIEW TO APPLY STYLE ON
         */
        public void applyStyle(@NonNull TextView _textview)
        {
            _textview.setMovementMethod(LinkMovementMethod.getInstance());
            _textview.setText(spannableString);
        }
        //endregion
    }




}
