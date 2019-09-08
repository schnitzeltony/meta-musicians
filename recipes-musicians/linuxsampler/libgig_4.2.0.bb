SUMMARY = "GigaStudio/Gigasampler, DLS, AKAI, SoundFont, KORG file access library"
HOMEPAGE = "http://www.linuxsampler.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=526c29250ae72f6933cdc01414b9943b \
"

DEPENDS = " \
    util-linux \
    libsndfile1 \
"

inherit autotools pkgconfig lib_package

SRC_URI = " \
    http://download.linuxsampler.org/packages/${BPN}-${PV}.tar.bz2 \
    file://0001-Adjust-libdir.patch \
"
SRC_URI[md5sum] = "5ab37d9d7532a4cd0ed5508b08b8d1d5"
SRC_URI[sha256sum] = "16229a46138b101eb9eda042c66d2cd652b1b3c9925a7d9577d52f2282f745ff"

do_install_append() {
    mv ${D}${libdir}/${BPN}/* ${D}${libdir}
    rmdir ${D}${libdir}/${BPN}
}
