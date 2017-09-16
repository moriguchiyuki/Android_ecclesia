package com.example.yuichi_oba.ecclesia.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yuki on 2017/09/08.
 */

public class Reseve_confirmView extends View {

    //*** Field ***//
    private Paint p_line;
    private Paint p_out_line;
    private Paint p_text;
    private Paint p_rect;       // 交互に色違いにする用

    //*** Constractor ***//
    public Reseve_confirmView(Context context) {
        super(context);
        init();
    }

    public Reseve_confirmView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Reseve_confirmView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //*** Paintクラスの初期化処理メソッド ***//
    private void init() {
        // 枠線用
        p_line = new Paint();
        p_line.setColor(Color.DKGRAY);
        p_line.setStyle(Paint.Style.STROKE);
        p_line.setStrokeWidth(10);

        p_out_line = new Paint();
        p_out_line.setStrokeWidth(2.0f);


        // テキスト用
        p_text = new Paint();
        p_text.setTypeface(Typeface.MONOSPACE);
        p_text.setTextSize(40);
        p_text.setTextAlign(Paint.Align.CENTER);
        p_text.setColor(Color.BLACK);

        // 色違い用
        p_rect = new Paint();
        p_rect.setColor(Color.LTGRAY);
        p_rect.setStyle(Paint.Style.FILL);

    }

    private String[] name = {"概要", "目的", "開始時間", "終了時間", "申請者", "参加者", "社内/社外", "会社名", "希望会議室", "備品", "その他"};
    private String[] content = {"システム開発の組み合わせ", "打合せ", "2017/01/18 09:00", "2017/01/18 11:00", "石山大樹", "大馬祐一 : 管理部", "社内", "株式会社Ostraca", "会議室A", "プロジェクタ", "無し"};

    //*** 描画メソッド ***//
    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        // l t r b
        c.drawRect(0, 1080, 0, 1920, p_line);
        float room = 120;
        float room_y = 70;
        p_text.setTextAlign(Paint.Align.LEFT);
        // sx = 左上 sy　=　左下 ex　=　幅 ey　=　右下
        c.drawLine(0, room, 1080, room, p_out_line);
        // 各項目を交互に、色違いにするロジック
        float padding = 3;
        for (int i = 1; i < 13; i += 2) {
            c.drawRect(0 + padding, room * i - room + padding, 1080 - padding, room * i - padding, p_rect);
        }

        for (int i = 1; i <= 11; i++) {
            c.drawLine(0, room * i, 1080, room * i, p_out_line);
            c.drawText(name[i - 1], 100, room_y, p_text);
            c.drawText(content[i - 1], 500, room_y, p_text);
            room_y += room;
        }
    }
}
