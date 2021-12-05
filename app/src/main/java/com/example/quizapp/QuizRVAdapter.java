package com.example.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizRVAdapter extends RecyclerView.Adapter<QuizRVAdapter.ViewHolder> {

    private ArrayList<AllQuizzesModal> quizzesModalArrayList;
    private Context context;

    // constructor
    public QuizRVAdapter(ArrayList<AllQuizzesModal> quizzesModalArrayList, Context context) {
        this.quizzesModalArrayList = quizzesModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflating our Layout with recycler view item layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Setting data to our views of recycler view item.
        AllQuizzesModal modal = quizzesModalArrayList.get(position);
        holder.quizNameTV.setText(modal.getQuizName());
        holder.numberOfQuestionsTV.setText("Number of Questions: " + modal.getNumberOfQuestions());
        holder.totalPointsTV.setText(  "Total Points: " + ( modal.getNumberOfQuestions() * modal.getPointsPerQuestion() )  );
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return quizzesModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView quizNameTV, numberOfQuestionsTV, totalPointsTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quizNameTV = itemView.findViewById(R.id.quiz_name_tv);
            numberOfQuestionsTV = itemView.findViewById(R.id.number_of_questions_tv);
            totalPointsTV = itemView.findViewById(R.id.total_points_tv);
        }
    }

}
