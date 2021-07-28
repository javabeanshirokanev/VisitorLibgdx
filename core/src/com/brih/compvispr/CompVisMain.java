package com.brih.compvispr;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.brih.compvispr.composite.GroupItem;
import com.brih.compvispr.composite.GroupMultItem;
import com.brih.compvispr.composite.Item;
import com.brih.compvispr.composite.Ring;

public class CompVisMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	private Item item;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		GroupItem group = new GroupItem();
		group.add(new Ring(2));

		GroupMultItem group1 = new GroupMultItem();
		group1.add(new Ring(3));
		group1.add(new Ring(4));

		group.add(group1);

		item = group;
		float def = item.calcShield();
		int c = 0;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
