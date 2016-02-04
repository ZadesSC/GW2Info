package io.zades.gw2info.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import io.zades.gw2info.R;
import io.zades.gw2info.data.ItemTable;
import io.zades.gw2info.data.pojo.ItemDatum;
import io.zades.gw2info.graphics.IconBorderTransformation;
import io.zades.gw2info.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemInfoFragment extends Fragment
{
	private static final String ITEM_ID_KEY = "item_id";

	private final ItemTable sTable = ItemTable.getInstance();
	private long mItemId;
	private ItemDatum mItem;

	private Toolbar mToolbar;
	private TextView mTextItemName;
	private TextView mTextItemDetail;
	private ImageView mImageItemIcon;

	public ItemInfoFragment()
	{
		// Required empty public constructor
	}

	public static ItemInfoFragment newInstance(long itemId)
	{
		ItemInfoFragment fragment = new ItemInfoFragment();
		Bundle bundle = new Bundle();
		bundle.putSerializable(ITEM_ID_KEY, itemId);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		mItemId = (long) getArguments().getSerializable(ITEM_ID_KEY);

		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_item_info, container, false);


		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		mToolbar = (Toolbar) getActivity().findViewById(R.id.app_bar);
		mTextItemName = (TextView) getActivity().findViewById(R.id.text_item_info_item_name);
		mTextItemDetail = (TextView) getActivity().findViewById(R.id.text_item_info_item_detail);
		mImageItemIcon = (ImageView) getActivity().findViewById(R.id.image_item_info_item_icon);

		mItem = sTable.getItemData(mItemId);

		if (mItem == null)
		{
			loadItem(mItemId);
		}
		else
		{
			setData();
		}
	}

	public void loadItem(long id)
	{

	}


	public void setData()
	{
		Picasso.with(getContext()).load(mItem.getIcon()).placeholder(R.drawable.icon_placeholder).transform(new IconBorderTransformation(mItem.getRarity(), 0, getContext())).into(mImageItemIcon);
		mTextItemName.setText(Html.fromHtml(getItemNameText(mItem)), TextView.BufferType.SPANNABLE);

		//details
		//need to figure out the type of item and display its details
		//TODO: fix hardcoded strings
		switch (mItem.getType())
		{
			case "Armor":
				break;
			case "Back":
				break;
			case "Bag":
				break;
			case "Consumable":
				break;
			case "Container":
				break;
			case "CraftingMaterial":
				break;
			case "Gathering":
				break;
			case "Gizmo":
				break;
			case "Minipet":
				break;
			case "Tool":
				break;
			case "Trait":
				break;
			case "Trinket":
				break;
			case "Trophy":
				break;
			case "UpgradeComponent":
				break;
			case "Weapon":
				setWeaponData();
				break;
			default:
				break;
		}
	}


	public void setWeaponData()
	{
		if (mItem.getDetails().getType().equals("Shield"))
		{

		}
		else if (mItem.getDetails().getType().equals("LargeBundle"))
		{

		}
		else if (mItem.getDetails().getType().equals("SmallBundle"))
		{

		}
		else if (mItem.getDetails().getType().equals("Toy"))
		{

		}
		else if (mItem.getDetails().getType().equals("TwoHandedToy"))
		{

		}
		else
		{
			String finalText = getStrengthText(mItem)
					+ getAttributeText(mItem)
					//+ getSkinText(mItem) TODO: skinssss
					+ getRarityText(mItem)
					+ getWeaponTypeText(mItem)
					+ getRequiredLevelText(mItem);

			mTextItemDetail.setText(Html.fromHtml(finalText), TextView.BufferType.SPANNABLE);
		}
	}

	public String getItemNameText(ItemDatum data)
	{
		String itemNameText = Utils.getHtmlColorText(data.getName(), Utils.getColorFromRarity(data.getRarity(), getContext()));
		return itemNameText;
	}

	public String getStrengthText(ItemDatum data)
	{
		String text = data.getDetails().getMinPower() + " - " + data.getDetails().getMaxPower();
		return "Weapon Strength: " + Utils.getHtmlColorText(text, ContextCompat.getColor(getContext(), R.color.itemTextGreen)) + "<br>";
	}

	public String getAttributeText(ItemDatum data)
	{
		String attrString = "";

		ItemDatum.InfixUpgrade infix = data.getDetails().getInfixUpgrade();
		for (ItemDatum.Attribute attr : infix.getAttributes())
		{
			attrString += "+" + attr.getModifier() + " " + attr.getAttribute() + "<br>";
		}

		attrString += "<br>";

		return Utils.getHtmlColorText(attrString, ContextCompat.getColor(getContext(), R.color.itemTextGreen));
	}

	public String getSkinText(ItemDatum data)
	{
		if (data.getDefaultSkin() == null)
		{
			return "";
		}

		return "Transmuted<br>" + data.getDefaultSkin() + "<br><br>";
	}

	public String getRarityText(ItemDatum data)
	{
		return data.getRarity() + "<br>";
	}

	public String getWeaponTypeText(ItemDatum data)
	{
		return data.getDetails().getType() + "<br>";
	}

	public String getRequiredLevelText(ItemDatum data)
	{
		if (data.getLevel() == null || data.getLevel() == 0)
		{
			return "";
		}

		return "Required Level: " + data.getLevel() + "<br>";
	}

	public String getFlagsText(ItemDatum data)
	{
		return "";
	}

	public String getVenderValueText(ItemDatum data)
	{
		return "";
	}

}
