//
// Created by Administrator on 2018/5/25.
//

#include "EncryptUtil.h"

#define RELESE_ARRAY(P) if (P)  \
{                               \
    delete[] P;                 \
    P = NULL;                   \
}

int Encrypt::encryptFile(string in_file_path, string out_file_path,
                             const char *rc4_encrypt_key) {
    int encrypt_chunk_size = 16;
    ifstream fin(in_file_path.c_str(), ios::binary);
    ofstream fout(out_file_path, ios::binary);

    if (!fin) {
//        LOGW(" Can not open fin file. ");
        return 1;
    }
    if (!fout) {
//        LOGW(" Can not open fout file. ");
        return 1;
    }

    //用指定密钥对一段内存进行加密，结果放在outbuffer中
    unsigned char aes_keybuf[32];
    memset(aes_keybuf, 0, sizeof(aes_keybuf));
    strcpy((char *) aes_keybuf, "zengraoli");
    AES_KEY aeskey;
    AES_set_encrypt_key(aes_keybuf, 256, &aeskey);

    char *in_data = new char[encrypt_chunk_size + 1];
    char *out_data = new char[encrypt_chunk_size + 1];
    while (!fin.eof()) {
        fin.read(in_data, encrypt_chunk_size);
        if (fin.gcount() < encrypt_chunk_size) {
            fout.write(in_data, fin.gcount());
        } else {
            AES_encrypt((const unsigned char *) in_data, (unsigned char *) out_data, &aeskey);
            fout.write(out_data, fin.gcount());
        }
    };

    fout.close();
    fin.close();

    RELESE_ARRAY(in_data);
    RELESE_ARRAY(out_data);

    return 0;
}


int Encrypt::decryptFile(string in_file_path, string out_file_path,
                             const char *rc4_dencrypt_key) {
    int encrypt_chunk_size = 16;
    ifstream fin(in_file_path.c_str(), ios::binary);
    ofstream fout(out_file_path, ios::binary);

    if (!fin) {
//        LOGW(" Can not open fin file. ");
        return 1;
    }
    if (!fout) {
//        LOGW(" Can not open fout file. ");
        return 1;
    }

    //用指定密钥对一段内存进行加密，结果放在outbuffer中
    unsigned char aes_keybuf[32];
    memset(aes_keybuf, 0, sizeof(aes_keybuf));
    strcpy((char *) aes_keybuf, "zengraoli");
    AES_KEY aeskey;
    AES_set_decrypt_key(aes_keybuf, 256, &aeskey);

    char *in_data = new char[encrypt_chunk_size + 1];
    char *out_data = new char[encrypt_chunk_size + 1];
    int i = 0;
    while (!fin.eof()) {
        fin.read(in_data, encrypt_chunk_size);
        if (fin.gcount() < encrypt_chunk_size) {
            fout.write(in_data, fin.gcount());
        } else {
            AES_decrypt((unsigned char *) in_data, (unsigned char *) out_data, &aeskey);
            fout.write(out_data, fin.gcount());
        }
    };

    fout.close();
    fin.close();

    RELESE_ARRAY(in_data);
    RELESE_ARRAY(out_data);

    return 0;
}