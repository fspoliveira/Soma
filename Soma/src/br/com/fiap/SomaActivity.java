package br.com.fiap;

import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SomaActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btnSoma = (Button) findViewById(R.id.btnSoma);
		btnSoma.setOnClickListener(this);

	}

	public void onClick(View v) {

		TextView first = (TextView) findViewById(R.id.txtfirstNumber);
		TextView second = (TextView) findViewById(R.id.txtsecondNumber);
		TextView resultado = (TextView) findViewById(R.id.txtResultado);

		SomaTO somaTO = new SomaTO(
				Integer.parseInt(first.getText().toString()),
				Integer.parseInt(second.getText().toString()));

		// Web Service

		Log.w("Minha app", "CHegou na chamada do web services");
		SomaServices ws = new SomaServices();
		resultado.setText(Integer.toString(ws.soma(somaTO)));

	}

}