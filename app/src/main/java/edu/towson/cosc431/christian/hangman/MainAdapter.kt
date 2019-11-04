package edu.towson.cosc431.christian.hangman

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.score.view.*

class MainAdapter(val names:ArrayList<Table>, val scores:ArrayList<ScoreTable>): RecyclerView.Adapter<CustomViewHolder>() {


    override fun getItemCount(): Int {
        return scores.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.score, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val name = names[position]
        val score = scores[position]
        holder?.view?.nameview.text = name.username
        holder?.view?.winview.text = "Win = " + score.win.toString()
        holder?.view?.lossview.text = "Loss = " + score.loss.toString()
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}