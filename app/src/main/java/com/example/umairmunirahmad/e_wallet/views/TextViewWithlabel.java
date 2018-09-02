package com.example.umairmunirahmad.e_wallet.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.umairmunirahmad.e_wallet.R;

class TextViewWithLabel extends LinearLayout {

    private String label;
    private String text;
    private boolean hideOnEmpty;

    private TextView labelView;
    private TextView textView;

    public TextViewWithLabel(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TextViewWithLabel, 0, 0);

        try {
            label = a.getString(R.styleable.TextViewWithLabel_label);
            text = a.getString(R.styleable.TextViewWithLabel_text);
            hideOnEmpty = a.getBoolean(R.styleable.TextViewWithLabel_hideOnEmpty, false);
        } finally {
            a.recycle();
        }

        View.inflate(getContext(), R.layout.layout_text_view_with_label, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        labelView = findViewById(R.id.labelView);
        textView = findViewById(R.id.textView);

        init();
    }

    private void init() {
        if (hideOnEmpty && (text == null || text.isEmpty())) {
            this.setVisibility(View.GONE);
        } else {
            this.setVisibility(View.VISIBLE);
        }

        if (label != null) {
            labelView.setText(label + ": ");
        }

        if (text != null) {
            textView.setText(text);
        }
    }

    public TextViewWithLabel setLabel(String label) {
        this.label = label;

        init();

        return this;
    }

    public TextViewWithLabel setText(String text) {
        this.text = text;

        init();

        return this;
    }

    public String getLabel() {
        return label;
    }

    public String getText() {
        return text;
    }

    public TextViewWithLabel setColor(String text){
        textView.setText(text);
        textView.setTextColor(Color.BLUE);
        //	labelView.setText("Status");
        return this;
    }
}

