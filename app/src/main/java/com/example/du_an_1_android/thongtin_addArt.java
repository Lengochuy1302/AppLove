package com.example.du_an_1_android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.github.drjacky.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class thongtin_addArt extends AppCompatActivity {
    ImageView troVe_mota;
    Button btnTT_Art;
    private static final int REQUEST_IMAGE_OPEN = 1;
    private static final int REQUEST_IMAGE_OPEN_2 = 2;
    private static final int REQUEST_IMAGE_OPEN_3 = 3;
    private static final int REQUEST_IMAGE_OPEN_4 = 4;
    private static final int REQUEST_IMAGE_OPEN_5 = 5;
    private static final int REQUEST_IMAGE_OPEN_6 = 6;
    private static final int REQUEST_IMAGE_OPEN_7 = 7;
    private static final int REQUEST_IMAGE_OPEN_8 = 8;
    private static final int REQUEST_IMAGE_OPEN_9 = 9;
    CardView addCase1;
    CardView addCase2;
    CardView addCase3;
    CardView addCase4;
    CardView addCase5;
    CardView addCase6;
    CardView addCase7;
    CardView addCase8;
    CardView addCase9;
    ImageView case1;
    ImageView case2;
    ImageView case3;
    ImageView case4;
    ImageView case5;
    ImageView case6;
    ImageView case7;
    ImageView case8;
    ImageView case9;

    // kho ảnh
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://du-an-1-android-75d60.appspot.com");

    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference node = db.getReference("Tai_Khoan");
    DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thongtin_add_art);
        //setOnclick để mở file ảnh
        firebaseAuth=FirebaseAuth.getInstance();
        addCase1 = findViewById(R.id.addcase1);
        addCase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(thongtin_addArt.this)
                        .crop (12F , 16f)	    			 // Cắt hình ảnh (Tùy chọn), Kiểm tra Tùy chỉnh để có thêm tùy chọn
                        .compress ( 1024 )			 // Kích thước hình ảnh cuối cùng sẽ nhỏ hơn 1 MB (Tùy chọn)
                        .maxResultSize ( 1080 , 1080 )	 // Độ phân giải hình ảnh cuối cùng sẽ là dưới 1080 x 1080 (Tùy chọn)
                        .start(REQUEST_IMAGE_OPEN);
            }
        });
        addCase2 = findViewById(R.id.addcase2);
        addCase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(thongtin_addArt.this)
                        .crop (12F , 16f)	    			 // Cắt hình ảnh (Tùy chọn), Kiểm tra Tùy chỉnh để có thêm tùy chọn
                        .compress ( 1024 )			 // Kích thước hình ảnh cuối cùng sẽ nhỏ hơn 1 MB (Tùy chọn)
                        .maxResultSize ( 1080 , 1080 )	 // Độ phân giải hình ảnh cuối cùng sẽ là dưới 1080 x 1080 (Tùy chọn)
                        .start(REQUEST_IMAGE_OPEN_2);
            }
        });
        addCase3 = findViewById(R.id.addcase3);
        addCase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(thongtin_addArt.this)
                        .crop (12F , 16f)	    			 // Cắt hình ảnh (Tùy chọn), Kiểm tra Tùy chỉnh để có thêm tùy chọn
                        .compress ( 1024 )			 // Kích thước hình ảnh cuối cùng sẽ nhỏ hơn 1 MB (Tùy chọn)
                        .maxResultSize ( 1080 , 1080 )	 // Độ phân giải hình ảnh cuối cùng sẽ là dưới 1080 x 1080 (Tùy chọn)
                        .start(REQUEST_IMAGE_OPEN_3);
            }
        });
        addCase4 = findViewById(R.id.addcase4);
        addCase4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(thongtin_addArt.this)
                        .crop (12F , 16f)	    			 // Cắt hình ảnh (Tùy chọn), Kiểm tra Tùy chỉnh để có thêm tùy chọn
                        .compress ( 1024 )			 // Kích thước hình ảnh cuối cùng sẽ nhỏ hơn 1 MB (Tùy chọn)
                        .maxResultSize ( 1080 , 1080 )	 // Độ phân giải hình ảnh cuối cùng sẽ là dưới 1080 x 1080 (Tùy chọn)
                        .start(REQUEST_IMAGE_OPEN_4);
            }
        });
        addCase5 = findViewById(R.id.addcase5);
        addCase5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(thongtin_addArt.this)
                        .crop (12F , 16f)	    			 // Cắt hình ảnh (Tùy chọn), Kiểm tra Tùy chỉnh để có thêm tùy chọn
                        .compress ( 1024 )			 // Kích thước hình ảnh cuối cùng sẽ nhỏ hơn 1 MB (Tùy chọn)
                        .maxResultSize ( 1080 , 1080 )	 // Độ phân giải hình ảnh cuối cùng sẽ là dưới 1080 x 1080 (Tùy chọn)
                        .start(REQUEST_IMAGE_OPEN_5);
            }
        });
        addCase6 = findViewById(R.id.addcase6);
        addCase6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(thongtin_addArt.this)
                        .crop (12F , 16f)	    			 // Cắt hình ảnh (Tùy chọn), Kiểm tra Tùy chỉnh để có thêm tùy chọn
                        .compress ( 1024 )			 // Kích thước hình ảnh cuối cùng sẽ nhỏ hơn 1 MB (Tùy chọn)
                        .maxResultSize ( 1080 , 1080 )	 // Độ phân giải hình ảnh cuối cùng sẽ là dưới 1080 x 1080 (Tùy chọn)
                        .start(REQUEST_IMAGE_OPEN_6);
            }
        });
        addCase7 = findViewById(R.id.addcase7);
        addCase7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(thongtin_addArt.this)
                        .crop (12F , 16f)	    			 // Cắt hình ảnh (Tùy chọn), Kiểm tra Tùy chỉnh để có thêm tùy chọn
                        .compress ( 1024 )			 // Kích thước hình ảnh cuối cùng sẽ nhỏ hơn 1 MB (Tùy chọn)
                        .maxResultSize ( 1080 , 1080 )	 // Độ phân giải hình ảnh cuối cùng sẽ là dưới 1080 x 1080 (Tùy chọn)
                        .start(REQUEST_IMAGE_OPEN_7);
            }
        });
        addCase8 = findViewById(R.id.addcase8);
        addCase8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(thongtin_addArt.this)
                        .crop (12F , 16f)	    			 // Cắt hình ảnh (Tùy chọn), Kiểm tra Tùy chỉnh để có thêm tùy chọn
                        .compress ( 1024 )			 // Kích thước hình ảnh cuối cùng sẽ nhỏ hơn 1 MB (Tùy chọn)
                        .maxResultSize ( 1080 , 1080 )	 // Độ phân giải hình ảnh cuối cùng sẽ là dưới 1080 x 1080 (Tùy chọn)
                        .start(REQUEST_IMAGE_OPEN_8);
            }
        });
        addCase9 = findViewById(R.id.addcase9);
        addCase9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(thongtin_addArt.this)
                        .crop (12F , 16f)	    			 // Cắt hình ảnh (Tùy chọn), Kiểm tra Tùy chỉnh để có thêm tùy chọn
                        .compress ( 1024 )			 // Kích thước hình ảnh cuối cùng sẽ nhỏ hơn 1 MB (Tùy chọn)
                        .maxResultSize ( 1080 , 1080 )	 // Độ phân giải hình ảnh cuối cùng sẽ là dưới 1080 x 1080 (Tùy chọn)
                        .start(REQUEST_IMAGE_OPEN_9);
            }
        });
        //setOnclick để mở file ảnh
        //        Trờ về
        troVe_mota = findViewById(R.id.back_Art);
        troVe_mota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thongtin_addArt.this, com.example.du_an_1_android.thongtin_mota.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
        //        Trờ về
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_OPEN && resultCode == RESULT_OK) {
            case1 = (ImageView) findViewById(R.id.case1);
            Uri full1 = data.getData();
            case1.setImageURI(full1);

        }
        if (requestCode == REQUEST_IMAGE_OPEN_2 && resultCode == RESULT_OK) {
            case2 = (ImageView) findViewById(R.id.case2);
            Uri full2 = data.getData();
            case2.setImageURI(full2);

        }
        if (requestCode == REQUEST_IMAGE_OPEN_3 && resultCode == RESULT_OK) {
            case3 = (ImageView) findViewById(R.id.case3);
            Uri full3 = data.getData();
            case3.setImageURI(full3);

        }
        if (requestCode == REQUEST_IMAGE_OPEN_4 && resultCode == RESULT_OK) {
            case4 = (ImageView) findViewById(R.id.case4);
            Uri full4 = data.getData();
            case4.setImageURI(full4);

        }
        if (requestCode == REQUEST_IMAGE_OPEN_5 && resultCode == RESULT_OK) {
            case5 = (ImageView) findViewById(R.id.case5);
            Uri full5 = data.getData();
            case5.setImageURI(full5);

        }
        if (requestCode == REQUEST_IMAGE_OPEN_6 && resultCode == RESULT_OK) {
            case6 = (ImageView) findViewById(R.id.case6);
            Uri full6 = data.getData();
            case6.setImageURI(full6);

        }
        if (requestCode == REQUEST_IMAGE_OPEN_7 && resultCode == RESULT_OK) {
            case7 = (ImageView) findViewById(R.id.case7);
            Uri full7 = data.getData();
            case7.setImageURI(full7);

        }
        if (requestCode == REQUEST_IMAGE_OPEN_8 && resultCode == RESULT_OK) {
            case8 = (ImageView) findViewById(R.id.case8);
            Uri full8 = data.getData();
            case8.setImageURI(full8);

        }
        if (requestCode == REQUEST_IMAGE_OPEN_9 && resultCode == RESULT_OK) {
            case9 = (ImageView) findViewById(R.id.case9);
            Uri full9 = data.getData();
            case9.setImageURI(full9);

        }

        btnTT_Art = findViewById(R.id.btnTT_Art);
        btnTT_Art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(case1 != null){
                    Calendar calendar = Calendar.getInstance();
                    StorageReference mountainsRef = storageRef.child("image" + calendar.getTimeInMillis() + ".png");
                    // Get the data from an ImageView as bytes
                    case1.setDrawingCacheEnabled(true);
                    case1.buildDrawingCache();
                    Bitmap bitmap = ((BitmapDrawable) case1.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                    byte[] data = baos.toByteArray();

                    UploadTask uploadTask = mountainsRef.putBytes(data);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(thongtin_addArt.this, "Loi up hinh", Toast.LENGTH_SHORT).show();
                        }

                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String id = firebaseAuth.getUid();
                                    ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                                    thongTinDangNhap.setHinh1("" + uri + "");
                                    Intent intentGEt = getIntent();
                                    String gioiTinh = intentGEt.getStringExtra("gt");
                                    node.child(id).updateChildren(thongTinDangNhap.toMapAnh1(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });
                                    nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapAnh1(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
                        }
                    });
                }

                if(case2 != null){
                    Calendar calendar2 = Calendar.getInstance();
                    StorageReference mountainsRef2 = storageRef.child("image" + calendar2.getTimeInMillis() + ".png");
                    case2.setDrawingCacheEnabled(true);
                    case2.buildDrawingCache();
                    Bitmap bitmap2 = ((BitmapDrawable) case2.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.PNG, 100, baos2);
                    byte[] data2 = baos2.toByteArray();
                    UploadTask uploadTask2 = mountainsRef2.putBytes(data2);
                    uploadTask2.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(thongtin_addArt.this, "Loi up hinh", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String id = firebaseAuth.getUid();
                                    ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                                    thongTinDangNhap.setHinh2("" + uri + "");

                                    Intent intentGEt = getIntent();
                                    String gioiTinh = intentGEt.getStringExtra("gt");
                                    node.child(id).updateChildren(thongTinDangNhap.toMapAnh2(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });
                                    nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapAnh2(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
                        }
                    });
                }
                if(case3 != null){
                    Calendar calendar3 = Calendar.getInstance();
                    StorageReference mountainsRef3 = storageRef.child("image" + calendar3.getTimeInMillis() + ".png");
                    case3.setDrawingCacheEnabled(true);
                    case3.buildDrawingCache();
                    Bitmap bitmap3 = ((BitmapDrawable) case3.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos3 = new ByteArrayOutputStream();
                    bitmap3.compress(Bitmap.CompressFormat.PNG, 100, baos3);
                    byte[] data3 = baos3.toByteArray();
                    UploadTask uploadTask3 = mountainsRef3.putBytes(data3);
                    uploadTask3.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(thongtin_addArt.this, "Loi up hinh", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String id = firebaseAuth.getUid();
                                    ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                                    thongTinDangNhap.setHinh3("" + uri + "");

                                    Intent intentGEt = getIntent();
                                    String gioiTinh = intentGEt.getStringExtra("gt");
                                    node.child(id).updateChildren(thongTinDangNhap.toMapAnh3(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });
                                    nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapAnh3(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
                        }
                    });
                }


                if(case4 != null) {
                    Calendar calendar4 = Calendar.getInstance();
                    StorageReference mountainsRef4 = storageRef.child("image" + calendar4.getTimeInMillis() + ".png");
                    case4.setDrawingCacheEnabled(true);
                    case4.buildDrawingCache();
                    Bitmap bitmap4 = ((BitmapDrawable) case4.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos4 = new ByteArrayOutputStream();
                    bitmap4.compress(Bitmap.CompressFormat.PNG, 100, baos4);
                    byte[] data4 = baos4.toByteArray();
                    UploadTask uploadTask4 = mountainsRef4.putBytes(data4);
                    uploadTask4.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(thongtin_addArt.this, "Loi up hinh", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String id = firebaseAuth.getUid();
                                    ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                                    thongTinDangNhap.setHinh4("" + uri + "");

                                    Intent intentGEt = getIntent();
                                    String gioiTinh = intentGEt.getStringExtra("gt");
                                    node.child(id).updateChildren(thongTinDangNhap.toMapAnh4(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });
                                    nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapAnh4(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
                        }
                    });

                }
                if(case5 != null){
                    Calendar calendar5 = Calendar.getInstance();
                    StorageReference mountainsRef5 = storageRef.child("image" + calendar5.getTimeInMillis() + ".png");
                    case5.setDrawingCacheEnabled(true);
                    case5.buildDrawingCache();
                    Bitmap bitmap5 = ((BitmapDrawable) case5.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos5 = new ByteArrayOutputStream();
                    bitmap5.compress(Bitmap.CompressFormat.PNG, 100, baos5);
                    byte[] data5 = baos5.toByteArray();
                    UploadTask uploadTask5 = mountainsRef5.putBytes(data5);
                    uploadTask5.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(thongtin_addArt.this, "Loi up hinh", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String id = firebaseAuth.getUid();
                                    ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                                    thongTinDangNhap.setHinh5("" + uri + "");

                                    Intent intentGEt = getIntent();
                                    String gioiTinh = intentGEt.getStringExtra("gt");
                                    node.child(id).updateChildren(thongTinDangNhap.toMapAnh5(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });
                                    nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapAnh5(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
                        }
                    });
                }




                if(case6 != null){
                    Calendar calendar6 = Calendar.getInstance();
                    StorageReference mountainsRef6 = storageRef.child("image" + calendar6.getTimeInMillis() + ".png");
                    case6.setDrawingCacheEnabled(true);
                    case6.buildDrawingCache();
                    Bitmap bitmap6 = ((BitmapDrawable) case6.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos6 = new ByteArrayOutputStream();
                    bitmap6.compress(Bitmap.CompressFormat.PNG, 100, baos6);
                    byte[] data6 = baos6.toByteArray();
                    UploadTask uploadTask6 = mountainsRef6.putBytes(data6);
                    uploadTask6.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(thongtin_addArt.this, "Loi up hinh", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String id = firebaseAuth.getUid();
                                    ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                                    thongTinDangNhap.setHinh6("" + uri + "");

                                    Intent intentGEt = getIntent();
                                    String gioiTinh = intentGEt.getStringExtra("gt");
                                    node.child(id).updateChildren(thongTinDangNhap.toMapAnh6(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });
                                    nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapAnh6(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
                        }
                    });

                }

                if(case7 != null){
                    Calendar calendar7 = Calendar.getInstance();
                    StorageReference mountainsRef7 = storageRef.child("image" + calendar7.getTimeInMillis() + ".png");
                    case7.setDrawingCacheEnabled(true);
                    case7.buildDrawingCache();
                    Bitmap bitmap7 = ((BitmapDrawable) case7.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos7 = new ByteArrayOutputStream();
                    bitmap7.compress(Bitmap.CompressFormat.PNG, 100, baos7);
                    byte[] data7 = baos7.toByteArray();
                    UploadTask uploadTask7 = mountainsRef7.putBytes(data7);
                    uploadTask7.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(thongtin_addArt.this, "Loi up hinh", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String id = firebaseAuth.getUid();
                                    ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                                    thongTinDangNhap.setHinh7("" + uri + "");

                                    Intent intentGEt = getIntent();
                                    String gioiTinh = intentGEt.getStringExtra("gt");
                                    node.child(id).updateChildren(thongTinDangNhap.toMapAnh7(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });
                                    nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapAnh7(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
                        }
                    });

                }



                if(case8 != null){
                    Calendar calendar8 = Calendar.getInstance();
                    StorageReference mountainsRef8 = storageRef.child("image" + calendar8.getTimeInMillis() + ".png");
                    case8.setDrawingCacheEnabled(true);
                    case8.buildDrawingCache();
                    Bitmap bitmap8 = ((BitmapDrawable) case8.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos8 = new ByteArrayOutputStream();
                    bitmap8.compress(Bitmap.CompressFormat.PNG, 100, baos8);
                    byte[] data8 = baos8.toByteArray();
                    UploadTask uploadTask8 = mountainsRef8.putBytes(data8);
                    uploadTask8.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(thongtin_addArt.this, "Loi up hinh", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String id = firebaseAuth.getUid();
                                    ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                                    thongTinDangNhap.setHinh8("" + uri + "");

                                    Intent intentGEt = getIntent();
                                    String gioiTinh = intentGEt.getStringExtra("gt");
                                    node.child(id).updateChildren(thongTinDangNhap.toMapAnh8(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });
                                    nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapAnh8(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });
                                    startActivity(new Intent(thongtin_addArt.this, Dieu_Khoan.class));
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
                        }
                    });

                }



                if(case9 != null){

                    Calendar calendar9 = Calendar.getInstance();
                    StorageReference mountainsRef9 = storageRef.child("image" + calendar9.getTimeInMillis() + ".png");
                    case9.setDrawingCacheEnabled(true);
                    case9.buildDrawingCache();
                    Bitmap bitmap9 = ((BitmapDrawable) case9.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos9 = new ByteArrayOutputStream();
                    bitmap9.compress(Bitmap.CompressFormat.PNG, 100, baos9);
                    byte[] data9 = baos9.toByteArray();
                    UploadTask uploadTask9 = mountainsRef9.putBytes(data9);
                    uploadTask9.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(thongtin_addArt.this, "Loi up hinh", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String id = firebaseAuth.getUid();
                                    ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                                    thongTinDangNhap.setHinh9("" + uri + "");

                                    Intent intentGEt = getIntent();
                                    String gioiTinh = intentGEt.getStringExtra("gt");
                                    node.child(id).updateChildren(thongTinDangNhap.toMapAnh9(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });
                                    nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapAnh9(), new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                            if (error == null) {
                                            }
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
                        }
                    });


                }
                Intent intentGEt = getIntent();
                String gioiTinh = intentGEt.getStringExtra("gt");
                Intent intent = new Intent(thongtin_addArt.this, Dieu_Khoan.class);
                intent.putExtra("gt",gioiTinh);
                startActivity(intent);








            }
        });








        super.onActivityResult(requestCode, resultCode, data);
    }



}