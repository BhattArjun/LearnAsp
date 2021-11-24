package arjun.mca.learnaspnet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AspNotes.newInstance] factory method to
 * create an instance of this fragment.
 */

class AspNotes : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //-------------------------------------------------------------------------------------------------------------------------------------//
        // Inflate the layout for this fragment

        var v = inflater.inflate(R.layout.fragment_asp_notes, container, false)


        var helper = MyDBHelper(requireContext())
        var db  = helper.readableDatabase

        var from = arrayOf("TITLE","NOTE")
        var to = intArrayOf(android.R.id.text1,android.R.id.text2)
        var rs = db.rawQuery("SELECT * FROM USERDATA",null)
        rs.requery()

        var adapter1 = SimpleCursorAdapter(requireContext(),
             android.R.layout.simple_list_item_2,
            //R.layout.mylayout,
            rs,
            arrayOf("TITLE","NOTE"),
            intArrayOf(android.R.id.text1,android.R.id.text2),
            //intArrayOf(R.id.t1,R.id.t2),
            0)


        var  lv = v.findViewById<ListView>(R.id.AspNote_lv)
        var adapter = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,from)
        adapter.notifyDataSetChanged()
        lv.adapter = adapter1

        lv.setOnItemClickListener { adapterView, view, i, l ->

            var intent = Intent(requireContext(),ListData::class.java)
            intent.putExtra("note",rs.getString(0))
            startActivity(intent)
        }

        fun refresh() {

            var helper = MyDBHelper(requireContext())
            var db  = helper.readableDatabase

            var from = arrayOf("TITLE","NOTE")
            var to = intArrayOf(android.R.id.text1,android.R.id.text2)
            var rs = db.rawQuery("SELECT * FROM USERDATA",null)


            var adapter1 = SimpleCursorAdapter(requireContext(),
                android.R.layout.simple_list_item_2,
                //R.layout.mylayout,
                rs,
                arrayOf("TITLE","NOTE"),
                intArrayOf(android.R.id.text1,android.R.id.text2),
                //intArrayOf(R.id.t1,R.id.t2),
                0)


            var adapter = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,from)
            adapter.notifyDataSetChanged()
            lv.adapter = adapter1

            lv.setOnItemClickListener { adapterView, view, i, l ->

                var intent = Intent(requireContext(),ListData::class.java)
                intent.putExtra("note",rs.getString(0))
                startActivity(intent)
            }

        }
        val swipeRefreshLayout = v.findViewById<SwipeRefreshLayout>(R.id.swipeToRefresh)
        //val textView = v.findViewById<TextView>(R.id.tv1)
        swipeRefreshLayout.setOnRefreshListener{

            refresh()
            swipeRefreshLayout.isRefreshing = false

        }

        return v
    }


    //-------------------------------------------------------------------------------------------------------------------------------------//

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AspNotes.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AspNotes().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}