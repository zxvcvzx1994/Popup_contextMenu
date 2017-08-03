package vo.cvcompany.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnPopup)
    Button btnPopup;
    private PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        registerForContextMenu(btnPopup);

    }
//    @OnClick(R.id.btnPopup)
//    public void btnPopup(){
//
//      //  popup();
//    }
//
    private void popup(){
        popupMenu = new PopupMenu(this, btnPopup);
        popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.popupDelete:
                        btnPopup.setText(getResources().getString(R.string.delete));
                        break;

                    case R.id.popupInsert:
                        btnPopup.setText(getResources().getString(R.string.insert));
                        break;
                    case R.id.popupUpdate:
                        btnPopup.setText(getResources().getString(R.string.update));
                        break;
                }
                return true;
            }
        });
        popupMenu.show();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.popup,menu);
        menu.setHeaderTitle("sdfsdfsdfsdf");

    }
}
