package com.subtlecreation.custompopup;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class PopWindow extends DialogFragment{
	interface OnPopWindowListener{
		void setSubmit(String submitText);
	}
	OnPopWindowListener listener;
	TextView content;
	Button submitButton;
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Dialog dialog = new Dialog(getActivity());
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
									WindowManager.LayoutParams.FLAG_FULLSCREEN);
		dialog.setContentView(R.layout.custom_dialog);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		dialog.show();
		content = (TextView)dialog.findViewById(R.id.content);
		submitButton = (Button)dialog.findViewById(R.id.submit);
		submitButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				listener.setSubmit(content.getText().toString());
				dismiss();
			}
		});
		return dialog;
	}
}
