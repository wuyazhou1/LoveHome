package com.example.administrator.publishlibrary.PublishlibraryAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.publishlibrary.R;

import java.util.List;

/**
 * Created by yinjianlin on 2016/8/12.
 */
public class PublishDialogBottomAdapter extends BaseAdapter {
    private List<String> objects;
    private List<Integer> img;

    private Context context;
    private LayoutInflater layoutInflater;

    public PublishDialogBottomAdapter(Context context,List<String> objects,List<Integer> img) {
        this.context = context;
        this.objects = objects;
        this.img = img;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public String getItem(int position) {
        return objects.get(position);
    }

    public int getImg(int position){return img.get(position);}

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.aublishadapter, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((String)getItem(position),getImg(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(String object,int img, ViewHolder holder) {
        //TODO implement
        holder.buttonCancle.setImageResource(img);
        holder.publishTv.setText(object);
    }

    protected class ViewHolder {
        private ImageView buttonCancle;
        private TextView publishTv;

        public ViewHolder(View view) {
            buttonCancle = (ImageView) view.findViewById(R.id.publish_img);
            publishTv = (TextView)view.findViewById(R.id.publish_tv);
        }
    }
}