package ak.andro.kumaraakash86.akuhsampleapp.samples;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuniversalhelper.Listeners.click.TextClicker;
import ak.andro.kumaraakash86.akuniversalhelper.Utilities.AKTextUtilities;

public class TextUtilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_util);

        SetTextUnderline();
    }

    private void SetTextUnderline() {
        AKTextUtilities.TextStyler textStyler = new AKTextUtilities.TextStyler();
        textStyler.Init(getString(R.string.msg_long_text));
        textStyler.setOverlookItems(new String[]{","});
        textStyler.doMatchExactly(false);
        textStyler.setUnderline("underline");
        textStyler.setBold("bold");
        textStyler.setItalic("italic");
        textStyler.setSize(2f, "resize");
        textStyler.setStrikethrough("strikethrough");
        textStyler.setSuperscript("superscript");
        textStyler.setSubscript("subscript");
        textStyler.setColor(Color.RED, "foreground-color");
        textStyler.setBGColor(Color.GREEN, "background-color");
        //textStyler.setLinkUnderline(false);                        // UNCOMMENT TO DISABLE LINK UNDERLINE
        //textStyler.setLinkColor(Color.argb(255, 200,70,200));      // UNCOMMENT TO SET LINK COLOR

        textStyler.setClickListener(new TextClicker() {
            @Override
            public void TextClicked(View view, CharSequence text) {
                Toast.makeText(getApplicationContext(), "You clicked : "+text, Toast.LENGTH_SHORT).show();
            }
        }, "textview", "click");

        textStyler.applyStyle((TextView) findViewById(R.id.tv_styling_text));
    }

}
