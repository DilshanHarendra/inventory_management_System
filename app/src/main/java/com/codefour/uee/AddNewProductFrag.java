package com.codefour.uee;

import android.Manifest;
import android.app.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codefour.uee.Products.ProductsController;

import static android.Manifest.permission.CAMERA;


public class AddNewProductFrag extends Fragment {

    private EditText proName,proId,proLocation,proPrice,proQty,proAlert,proCategory;
    private TextView proErr;
    private Button addButton,addImageBtn,removeImageBtn;
    private ImageView proImage;
    private String imageURI="NoImage";
    public static final int RUNTIME_PERMISSION_CODE = 7;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("ueeIn","On create");
        MainProductView.frag=2;
        View view=inflater.inflate(R.layout.fragment_add_new_product, container, false);

        proName=view.findViewById(R.id.proName);
        proId=view.findViewById(R.id.proId);
        proCategory=view.findViewById(R.id.proCategory);
        proLocation=view.findViewById(R.id.ProLocation);
        proPrice=view.findViewById(R.id.proPrice);
        proQty=view.findViewById(R.id.proQuantity);
        proAlert=view.findViewById(R.id.proAQty);

        proErr=view.findViewById(R.id.proErr);

        addButton=view.findViewById(R.id.addProductBtn);
        addImageBtn=view.findViewById(R.id.addProImage);
        removeImageBtn=view.findViewById(R.id.removeProImageBtn);

        proImage=view.findViewById(R.id.proImage);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mess= ProductsController.addNewProduct(getActivity(),proName.getText().toString(),proId.getText().toString(),proCategory.getText().toString(),proLocation.getText().toString(),proQty.getText().toString(),proPrice.getText().toString(),proAlert.getText().toString(),imageURI);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.productViewFrag, new ProductListFrag());
                transaction.commit();

            }
        });

        addImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        if (checkPermission()){
                            Log.d("ueeIn","Permissiont hiyanwa");
                            Toast.makeText(getActivity(),"Permission is Granted!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent();
                            intent.setType("image/*");
                            intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                            startActivityForResult(Intent.createChooser(intent,"Select Image"),1);
                        }else {
                            Log.d("ueeIn","Permission na");
                            requestPermission();
                        }
                    }
                }catch (Exception e){
                    Log.d("ueeIn","err "+e);
                }





            }
        });

        removeImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageURI="NoImage";
                proImage.setImageDrawable(getResources().getDrawable(R.drawable.dummyproduct));
                removeImageBtn.setVisibility(View.INVISIBLE);
                addImageBtn.setText("Add Image");
            }
        });



        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode== Activity.RESULT_OK){
            Log.d("ueeIn",data.getData().toString());
            imageURI=data.getData().toString();
            proImage.setImageURI(data.getData());
            removeImageBtn.setVisibility(View.VISIBLE);
            addImageBtn.setText("Change Image");
            Log.d("ueeIn",imageURI);
        }
    }





    private boolean checkPermission(){
        return (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED);
    }
    private void requestPermission(){

        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, RUNTIME_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case RUNTIME_PERMISSION_CODE :
                if (grantResults.length > 0){
                    boolean storageAceepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (storageAceepted){
                        //Toast.makeText(getActivity(),"Permission granted", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                        startActivityForResult(Intent.createChooser(intent,"Select Image"),1);
                    }else {
                        Toast.makeText(getActivity(),"Permission denied", Toast.LENGTH_LONG).show();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)){
                                displayAlertMessage("You need to allow access for both permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, RUNTIME_PERMISSION_CODE);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
                break;
        }
    }
    public void displayAlertMessage(String message, DialogInterface.OnClickListener listener){
        new AlertDialog.Builder(getActivity())
                .setMessage(message)
                .setPositiveButton("OK", listener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }






}
