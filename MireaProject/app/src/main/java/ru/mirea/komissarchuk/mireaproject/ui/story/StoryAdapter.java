package ru.mirea.komissarchuk.mireaproject.ui.story;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mirea.komissarchuk.mireaproject.R;
import ru.mirea.komissarchuk.mireaproject.ui.story.db.Story;
import ru.mirea.komissarchuk.mireaproject.ui.story.db.StoryDB;
import ru.mirea.komissarchuk.mireaproject.ui.story.db.StoryDao;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    StoryDB db;
    StoryDao storyDao;
    Story story;

    StoryAdapter(Context context, StoryDB db) {
        this.db = db;
        storyDao = db.storyDao();
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        story = storyDao.getById(position + 1);
        holder.storyTitle.setText(story.title);
        holder.storyContent.setText(story.content);
    }

    @Override
    public int getItemCount() {
        return db.storyDao().getCount();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView storyTitle, storyContent;
        ViewHolder(View view){
            super(view);
            storyTitle = view.findViewById(R.id.storyTitle);
            storyContent = view.findViewById(R.id.storyContent);
        }
    }
}
