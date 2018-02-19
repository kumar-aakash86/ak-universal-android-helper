package ak.andro.kumaraakash86.akuhsampleapp.samples;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuniversalhelper.Utilities.AKDateUtilities;

public class DateActivity extends AppCompatActivity {

    Context mContext;

    Calendar calendar;
    String selectedDate;

    TextView tv_date_difference_startdate, tv_date_difference_enddate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        mContext= this;

        calendar = Calendar.getInstance();
        InitControls();
        SetupDates();
    }

    private void InitControls() {
        tv_date_difference_startdate = (TextView) findViewById(R.id.tv_date_difference_startdate);
        tv_date_difference_enddate = (TextView) findViewById(R.id.tv_date_difference_enddate);
    }

    private void SetupDates(){
        Date now = new Date();
        ((TextView) findViewById(R.id.tv_default_date)).setText(now.toString());

        ((TextView) findViewById(R.id.tv_format_date_1)).setText(AKDateUtilities.convertDate(now.toString(), "EEE MMM dd HH:mm:ss zzz yyyy", "dd-MMM-yyyy hh:mm:ss aa")+"\n(dd-MMM-yyyy hh:mm:ss aa)");
        ((TextView) findViewById(R.id.tv_format_date_2)).setText(AKDateUtilities.convertDate(now.toString(), "EEE MMM dd HH:mm:ss zzz yyyy", "MMM dd, yyyy HH:mm:ss")+"\n(MMM dd, yyyy HH:mm:ss)");

        ((TextView) findViewById(R.id.tv_string_date_1)).setText(AKDateUtilities.stringToDate("03/12/2013", "MM/dd/yyyy").toString());

        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date tommorow = calendar.getTime();
        selectedDate = AKDateUtilities.convertDate(tommorow.toString(), "EEE MMM dd HH:mm:ss zzz yyyy", "dd-MM-yyyy");
        ((TextView) findViewById(R.id.tv_date_from)).setText(selectedDate);
        ((TextView) findViewById(R.id.tv_date_from_result)).setText("Days from now : "+AKDateUtilities.DaysFromNow(tommorow));
        ((TextView) findViewById(R.id.tv_date_from_result2)).setText("Days from now (+2 DAYS) : "+AKDateUtilities.DaysFromNow(tommorow, 2));
        ((TextView) findViewById(R.id.tv_date_from_result3)).setText("Readable Format : "+AKDateUtilities.convertToReadableDate(mContext, selectedDate, "dd-MM-yyyy"));
        SetupDatePicker(R.id.tv_date_from);

        tv_date_difference_startdate.setText(AKDateUtilities.convertDate(now.toString(), "EEE MMM dd HH:mm:ss zzz yyyy", "dd-MMM-yyyy hh:mm:ss aa")+"\n(dd-MMM-yyyy hh:mm:ss aa)");
        tv_date_difference_enddate.setText(AKDateUtilities.convertDate(now.toString(), "EEE MMM dd HH:mm:ss zzz yyyy", "dd-MMM-yyyy hh:mm:ss aa")+"\n(dd-MMM-yyyy hh:mm:ss aa)");
    }

    private void SetupDatePicker(int id){
        TextView tv = (TextView) findViewById(id);
        tv.setOnClickListener(changeDate);
    }

    public View.OnClickListener changeDate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Calendar c = Calendar.getInstance();
            if(selectedDate != null)
                c.setTime(AKDateUtilities.stringToDate(  selectedDate, "dd-MM-yyyy"));
            final int y = c.get(Calendar.YEAR);
            int m = c.get(Calendar.MONTH);
            int d = c.get(Calendar.DAY_OF_MONTH);
//                final String[] MONTH = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

            DatePickerDialog dp = new DatePickerDialog(mContext,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int yearOfDate,
                                              int monthOfYear, int dayOfMonth) {
                            String erg = "";
                            erg = String.valueOf(dayOfMonth);
                            erg += "." +  String.valueOf(monthOfYear + 1);
                            erg += "." + yearOfDate;

                            selectedDate = dayOfMonth+"-"+(monthOfYear+1)+"-"+yearOfDate;
                            ((TextView) findViewById(R.id.tv_date_from)).setText(selectedDate);
                            ((TextView) findViewById(R.id.tv_date_from_result)).setText("Days from now : "+AKDateUtilities.DaysFromNow(AKDateUtilities.stringToDate(selectedDate, "dd-MM-yyyy")));
                            ((TextView) findViewById(R.id.tv_date_from_result2)).setText("Days from now (+2 DAYS) : "+AKDateUtilities.DaysFromNow(AKDateUtilities.stringToDate(selectedDate, "dd-MM-yyyy"), 2));
                            ((TextView) findViewById(R.id.tv_date_from_result3)).setText("Readable Format : "+AKDateUtilities.convertToReadableDate(mContext, selectedDate, "dd-MM-yyyy"));
                        }
                    }, y, m, d);
//                dp = new DatePickerDialog(mContext);
            Calendar cal=Calendar.getInstance();
//                dp.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
            cal.add(Calendar.YEAR, 2);
            dp.getDatePicker().setCalendarViewShown(false);
//                dp.getDatePicker().setMaxDate(cal.getTimeInMillis());
            dp.setTitle("");
            dp.show();
        }
    };


    public View.OnClickListener checkDifferences = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Calendar c = Calendar.getInstance();
            if(selectedDate != null)
                c.setTime(AKDateUtilities.stringToDate(  selectedDate, "dd-MM-yyyy"));
            final int y = c.get(Calendar.YEAR);
            int m = c.get(Calendar.MONTH);
            int d = c.get(Calendar.DAY_OF_MONTH);
//                final String[] MONTH = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

            DatePickerDialog dp = new DatePickerDialog(mContext,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int yearOfDate,
                                              int monthOfYear, int dayOfMonth) {
                            String erg = "";
                            erg = String.valueOf(dayOfMonth);
                            erg += "." +  String.valueOf(monthOfYear + 1);
                            erg += "." + yearOfDate;

                            selectedDate = dayOfMonth+"-"+(monthOfYear+1)+"-"+yearOfDate;
                            ((TextView) findViewById(R.id.tv_date_from)).setText(selectedDate);
                            ((TextView) findViewById(R.id.tv_date_from_result)).setText("Days from now : "+AKDateUtilities.DaysFromNow(AKDateUtilities.stringToDate(selectedDate, "dd-MM-yyyy")));
                            ((TextView) findViewById(R.id.tv_date_from_result2)).setText("Days from now (+2 DAYS) : "+AKDateUtilities.DaysFromNow(AKDateUtilities.stringToDate(selectedDate, "dd-MM-yyyy"), 2));
                            ((TextView) findViewById(R.id.tv_date_from_result3)).setText("Readable Format : "+AKDateUtilities.convertToReadableDate(mContext, selectedDate, "dd-MM-yyyy"));
                        }
                    }, y, m, d);
//                dp = new DatePickerDialog(mContext);
            Calendar cal=Calendar.getInstance();
//                dp.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
            cal.add(Calendar.YEAR, 2);
            dp.getDatePicker().setCalendarViewShown(false);
//                dp.getDatePicker().setMaxDate(cal.getTimeInMillis());
            dp.setTitle("");
            dp.show();
        }
    };
}
