package ak.andro.app.akuniversalhelper.Alerts;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by AAKASH on 08-10-2016.
 */
public class SnackFunctions {

    public enum SnackType
    {
        Alert,
        Success,
        Info
    };

    public static void ShowSnackbar(Activity _activity, String _msg)
    {
        Snackbar.make(_activity.findViewById(android.R.id.content), _msg, Snackbar.LENGTH_LONG).show();
    }
    public static void ShowSnackbar(Activity _activity, String _msg, SnackType _type)
    {
        int _color;
        switch (_type)
        {
            case Alert:
                _color = 0xFFF23F19;
                break;
            case Success:
                _color = 0xFF53B808;
                break;
            case Info:
                _color = 0xFFF1C40F;
                break;
            default:
                _color = 0xFF000000;
        }

        CustomSnackbar(Snackbar.make(_activity.findViewById(android.R.id.content), _msg, Snackbar.LENGTH_LONG), _color).show();
    }
    public static void ShowSnackbar(Activity _activity, String _msg, int _color)
    {
        CustomSnackbar(Snackbar.make(_activity.findViewById(android.R.id.content), _msg, Snackbar.LENGTH_LONG), _color).show();
    }

    private static Snackbar CustomSnackbar(Snackbar _snackBar, int _color)
    {
        View localView = getSBLayout(_snackBar);
        if (localView != null) {
            localView.setBackgroundColor(_color);
        }
        return _snackBar;
    }

    private static View getSBLayout(Snackbar _snackBar)
    {
        if (_snackBar != null) {
            return _snackBar.getView();
        }
        return null;
    }
}
