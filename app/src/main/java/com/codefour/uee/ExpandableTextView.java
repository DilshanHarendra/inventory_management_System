package com.codefour.uee;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableTextView extends BaseExpandableListAdapter {

    Context context;

    String[] setting={
            "Change Language",
            "Change Pin",
            "Change Name"
    };

    String[][] answer={
            {
                "Current Language:- English (US)"},
            {"Toggle to change pin input"
            },

            {
                "Name :- Vidula Dantanarayana,"

            }
    };


    public ExpandableTextView(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return setting.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return answer[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return setting[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return answer[i][i1];
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {


        String questionSeting = (String)getGroup(i);

        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.setting_title,null);
        }

        TextView question=view.findViewById(R.id.settingTitleView);

        question.setTypeface(null, Typeface.BOLD);
        question.setText(questionSeting);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        final String answerSetting = (String)getChild(i,i1);

        if(view ==null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.setting_answer,null);
        }

        TextView answerseting2 = view.findViewById(R.id.descriptionTextView);
        answerseting2.setText(answerSetting);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
