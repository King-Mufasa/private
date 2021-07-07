/*
 * This file is part of PCAPdroid.
 *
 * PCAPdroid is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PCAPdroid is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PCAPdroid.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2020-21 - Emanuele Faranda
 */

package com.emanuelef.remote_capture.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.interfaces.TextAdapter;
import com.emanuelef.remote_capture.model.ConnectionsMatcher;

import java.util.Iterator;

public class WhitelistEditAdapter extends ArrayAdapter<ConnectionsMatcher.Item> implements TextAdapter {
    private final LayoutInflater mLayoutInflater;

    public WhitelistEditAdapter(Context context, Iterator<ConnectionsMatcher.Item> items) {
        super(context, R.layout.whitelist_item);
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        while(items.hasNext()) {
            ConnectionsMatcher.Item item = items.next();
            add(item);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = mLayoutInflater.inflate(R.layout.whitelist_item, parent, false);

        ConnectionsMatcher.Item item = getItem(position);
        ((TextView)convertView.findViewById(R.id.item_label)).setText(item.getLabel());

        return convertView;
    }

    @Override
    public String getItemText(int pos) {
        return getItem(pos).getLabel();
    }
}
