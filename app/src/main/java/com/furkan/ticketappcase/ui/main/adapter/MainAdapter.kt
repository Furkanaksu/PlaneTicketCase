package com.furkan.ticketappcase.ui.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.furkan.ticketappcase.R
import com.furkan.ticketappcase.base.BaseAdapter
import com.furkan.ticketappcase.data.model.data.Airline
import com.furkan.ticketappcase.data.model.data.Departure
import com.furkan.ticketappcase.databinding.ItemSongBinding
import com.furkan.ticketappcase.utils.decode
import com.furkan.ticketappcase.utils.extension.loadImage

class MainAdapter(
    private val itemClick: ((Departure) -> Unit)?,
    private val airlines : ArrayList<Airline>? = null
) : BaseAdapter<Departure, MainAdapter.ViewHolder>() {

    @SuppressLint("SetTextI18n")
    override fun bindView(holder: ViewHolder, position: Int, item: Departure) {
        item.segments?.first()?.origin?.let{ holder.binding.departure.text = "$it > ${item.segments.first().destination}" }

        item.segments?.first()?.departure_datetime?.time.let { holder.binding.departureTime.text = it }
        item.segments?.first()?.arrival_datetime?.time.let { holder.binding.arrivalTime.text = it }

        item.price_breakdown?.total.let { holder.binding.price.text = it.toString() + " TL"  }


        if (item.segments?.size?:0 == 1)
        {
            holder.binding.flyType.apply {
                this.text = this.context.getString(R.string.directFly)
            }
        }
        else
        {
            holder.binding.flyType.apply {
                this.text = this.context.getString(R.string.withTransferFly)
            }
        }

        if (airlines != null) {
            for (data in airlines){
                if (item.segments?.first()?.marketing_airline == data.code)
                {
                    holder.binding.airlines.text = decode(data.name!!)
                    data.image?.let { holder.binding.image.loadImage(it.replace("\\","")) }
                }
            }
        }

        if (item.infos?.baggage_info?.firstBaggageCollection.isNullOrEmpty()){
            holder.binding.baggage.text = holder.binding.baggage.context.getString(R.string.hand_baggage)
        }else{
            holder.binding.baggage.text = item.infos?.baggage_info?.firstBaggageCollection?.first()?.allowance.toString() + "kg/kişi"
        }

        holder.binding.container.setOnClickListener {
            itemClick?.let { it1 -> it1(item) }
        }
    }

    
    override fun createView(
        context: Context,
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(ItemSongBinding.inflate(inflater, parent, false))
    }

    class ViewHolder(val binding: ItemSongBinding) :
        RecyclerView.ViewHolder(binding.root)

}