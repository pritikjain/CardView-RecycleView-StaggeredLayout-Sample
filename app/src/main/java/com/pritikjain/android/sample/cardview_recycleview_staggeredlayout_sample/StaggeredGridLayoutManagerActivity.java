package com.pritikjain.android.sample.cardview_recycleview_staggeredlayout_sample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class StaggeredGridLayoutManagerActivity extends ActionBarActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid_manager);
        initComponents();
    }

    private void initComponents(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("StaggeredGrid Layout");

        String[] dataset={ " One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"};
        int[] images = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9};
        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecycleViewAdapter(dataset,images);
        mRecyclerView.setAdapter(mAdapter);

    }

    public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

        private String[] mDataset;
        private int[] mImages;

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mTextView;
            public ImageView mImageView;

            public ViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView)itemView.findViewById(R.id.txt);
                mImageView = (ImageView)itemView.findViewById(R.id.img);

            }
        }

        public RecycleViewAdapter(String[] myDataset, int[] myImages) {
            mDataset = myDataset;
            mImages = myImages;
        }

        @Override
        public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.text_view_staggered,parent,false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(RecycleViewAdapter.ViewHolder holder, int position) {
            if(holder != null) {
                holder.mTextView.setText(mDataset[position]);
                holder.mImageView.setImageResource(mImages[position]);
            }
        }

        @Override
        public int getItemCount() {
            return mDataset.length;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }



}
