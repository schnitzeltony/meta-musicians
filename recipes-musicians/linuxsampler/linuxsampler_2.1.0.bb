SUMMARY = "LinuxSampler - modular, streaming capable sampler"
HOMEPAGE = "http://www.linuxsampler.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=0640e0c29fde7334746a009461544030 \
"

inherit autotools pkgconfig

DEPENDS = " \
    bison-native \
    bison \
    libgig \
    jack \
    dssi \
    lv2 \
"

SRC_URI = " \
    http://download.linuxsampler.org/packages/${BPN}-${PV}.tar.bz2 \
    file://0001-configure.ac-Do-not-try-to-run-code-to-check-for-UNI.patch \
"
SRC_URI[md5sum] = "c57fbd1310e9189ee72acf81e63bf3d5"
SRC_URI[sha256sum] = "4e0a49efeae9c26a223094247b7e01108d829a69618492282a203a290fbfbd39"

EXTRA_OECONF = " \
    --enable-unsigned-triang-algo=intmathabs \
    --enable-signed-triang-algo=intmathabs \
"

