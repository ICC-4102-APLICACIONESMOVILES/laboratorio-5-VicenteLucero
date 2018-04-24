package com.example.gamma.lab05;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class FormulariosModel {
    @NonNull
    @PrimaryKey
    private String formId;
    private String formName;
    private String formDate;
    private String formCategory;
    private String formComment;

    public FormulariosModel() {
    }

    public String getFormId() { return formId; }
    public void setFormId(String formId) { this.formId = formId; }
    public String getFormName() { return formName; }
    public void setFormName (String formName) { this.formName = formName; }
    public String getFormDate() {return formDate;}
    public void setFormDate(String formDate) {this.formDate = formDate;}
    public String getFormCategory(){return formCategory;}
    public void setFormCategory(String formCategory){this.formCategory = formCategory;}
    public String getFormComment(){return formComment;}
    public void setFormComment(String formComment){this.formComment = formComment;}
}
