package edu.byu.dtaylor.homeworknotifier;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.byu.dtaylor.homeworknotifier.schedule.recyclerviewresources.ScheduleRVAdapter;

public class AssignmentDialogFragment extends DialogFragment {

    private NoticeDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String name = getArguments().getString("name");
        String desc = getArguments().getString("description");
        String dueDate = getArguments().getString("dueDate");
        String pointsPossible = getArguments().getString("points");
        String course = getArguments().getString("course");
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_assignment_dialog, null);
        TextView dialogTitle = (TextView)view.findViewById(R.id.dialog_title);
        TextView dialogDescription = (TextView)view.findViewById(R.id.dialog_description);
        TextView dialogPoints = (TextView)view.findViewById(R.id.dialog_points);
        TextView dialogCourse= (TextView)view.findViewById(R.id.dialog_course);
        if(name != null && desc != null && dueDate != null) {
            dialogDescription.setText(desc);
            dialogTitle.setText(name);
            dialogPoints.setText(pointsPossible);
            dialogCourse.setText(course);
        }
        else
        {
            dialogTitle.setText("ERROR");
            dialogDescription.setText("Invalid arguments");
            dialogPoints.setText("9999999 points");
            dialogCourse.setText("LIFE 101");
        }
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(mListener != null)
                            mListener.onDialogPositiveClick(AssignmentDialogFragment.this);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    //Listener for callback on clicking to respond to activity on dialog complete
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if( activity instanceof NoticeDialogListener)
            mListener = (NoticeDialogListener) activity;
    }
    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }


}
