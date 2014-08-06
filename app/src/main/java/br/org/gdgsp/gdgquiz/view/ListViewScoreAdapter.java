package br.org.gdgsp.gdgquiz.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.org.gdgsp.gdgquiz.domain.Score;

/**
 * Created by pveronezi on 27/07/14.
 */
public class ListViewScoreAdapter extends BaseAdapter {

    private Context context;
    private List<Score> scoreList;
    private ViewHolder holder;
    private Score tempScore;

    public ListViewScoreAdapter(Context context, List<Score> scoreList) {
        this.context = context;
        this.scoreList = scoreList;
    }

    @Override
    public int getCount() {
        return scoreList.size();
    }

    @Override
    public Object getItem(int i) {
        return scoreList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return scoreList.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_score, viewGroup, false);

            holder = new ViewHolder();

            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            holder.name = (TextView) view.findViewById(R.id.textViewName);
            holder.victory = (TextView) view.findViewById(R.id.textViewDescription);
            holder.temp = (TextView) view.findViewById(R.id.textViewMinutes);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        tempScore = scoreList.get(position);

        // TODO verificar a imagem
        // holder.imageView.setImageBitmap(tempScore.getImagem());

        holder.name.setText(tempScore.getName());
        holder.temp.setText(tempScore.getTime() + context.getString(R.string.minutes));
        holder.victory.setText(tempScore.isVictory() ? context.getString(R.string.victory_in) + ": " : context.getString(R.string.defeated_in) + ": ");

        return view;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView name;
        TextView victory;
        TextView temp;
    }
}
