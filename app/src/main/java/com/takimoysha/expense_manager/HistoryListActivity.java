package com.takimoysha.expense_manager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HistoryListActivity extends AppCompatActivity {

    private RecyclerView RecyclerView;
    private List<Record> Data = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);
        RecyclerView = findViewById(R.id.list);
        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new checkHistoryListAdapter();
        RecyclerView.setAdapter(mAdapter);
        createDate();
    }

    private void createDate() {
        Data.add(new Record("Проезд", 12));
        Data.add(new Record("Покушать", 323));
        Data.add(new Record("Шоколадка", 32));
        Data.add(new Record("Еще чт-то", 5000));
        Data.add(new Record("Второе", 123));
        Data.add(new Record("Первое", 9129));
        Data.add(new Record("Покушать", 323));
        Data.add(new Record("Шоколадка", 32));
        Data.add(new Record("Еще чт-то", 5000));
        Data.add(new Record("Второе", 123));
        Data.add(new Record("Первое", 9129));
        Data.add(new Record("Покушать", 323));
        Data.add(new Record("Шоколадка", 32));
        Data.add(new Record("Еще чт-то", 5000));
        Data.add(new Record("Второе", 123));
        Data.add(new Record("Первое", 9129));
    }

    private class checkHistoryListAdapter extends RecyclerView.Adapter<RecordViewHolder> {

        public RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.check_record, parent, false);
            return new RecordViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecordViewHolder holder, int position) {
            Record record = Data.get(position);
            holder.applyData(record);
        }

        public int getItemCount() { return Data.size(); }
    }

    private class RecordViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView price;

        public RecordViewHolder(View checkView) {
            super(checkView);
            title = checkView.findViewById(R.id.title);
            price = checkView.findViewById(R.id.price);
        }

        public void applyData(Record record) {
            title.setText(record.getTitle());
            price.setText(String.valueOf(record.getPrice()));
        }
    }
}
