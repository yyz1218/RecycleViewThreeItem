package android.esports.zzdj.com.recycleviewthreeitem;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyRecycleViewAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ItemBean> list;
    public MyRecycleViewAdapter(Context context,ArrayList<ItemBean> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof ViewHolder) {
            final ViewHolder holder = (ViewHolder) viewHolder;
            if(list.size()%3>0) {
                int remainder = list.size()%3;
                int lineNum = list.size()/3;
                if(i==lineNum){
                        switch (remainder){
                            case 1:
                                holder.tv1.setText(list.get(lineNum*3).getContent());
                                holder.tv2.setVisibility(View.INVISIBLE);
                                holder.tv3.setVisibility(View.INVISIBLE);
                                break;
                            case 2:
                                holder.tv1.setText(list.get(lineNum*3).getContent());
                                holder.tv2.setText(list.get(lineNum*3+1).getContent()+"JNI");
                                holder.tv3.setVisibility(View.INVISIBLE);
                                break;
                                default:
                                    break;
                        }
                }else{
                    holder.tv1.setText(list.get(i*3).getContent());
                    holder.tv2.setText(list.get(i*3+1).getContent()+"哈");
                    holder.tv3.setText(list.get(i*3+2).getContent());
                }
            } else {
                holder.tv1.setText(list.get(i*3).getContent());
                holder.tv2.setText(list.get(i*3+1).getContent()+"哈");
                holder.tv3.setText(list.get(i*3+2).getContent());
            }
            holder.tv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(list.get(i*3).isSelect()){
                        list.get(i*3).setSelect(false);
                        holder.tv1.setBackgroundColor(Color.parseColor("#000000"));
                    }else{
                        list.get(i*3).setSelect(true);
                        holder.tv1.setBackgroundColor(Color.parseColor("#FF4081"));
                    }
                }
            });
            holder.tv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(list.get(i*3+1).isSelect()){
                        list.get(i*3+1).setSelect(false);
                        holder.tv2.setBackgroundColor(Color.parseColor("#000000"));
                    }else{
                        list.get(i*3+1).setSelect(true);
                        holder.tv2.setBackgroundColor(Color.parseColor("#FF4081"));
                    }
                }
            });
            holder.tv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(list.get(i*3+2).isSelect()){
                        list.get(i*3+2).setSelect(false);
                        holder.tv3.setBackgroundColor(Color.parseColor("#000000"));
                    }else{
                        list.get(i*3+2).setSelect(true);
                        holder.tv3.setBackgroundColor(Color.parseColor("#FF4081"));
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        if(list.size()%3>0) {
            return list.size()/3+1;
        } else {
            return list.size()/3;
        }
    }
    private class  ViewHolder extends RecyclerView.ViewHolder{
        TextView tv1;
        TextView tv2;
        TextView tv3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
}
