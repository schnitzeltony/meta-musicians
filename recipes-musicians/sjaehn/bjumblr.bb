SUMMARY = "Pattern-controlled audio stream / sample re-sequencer LV2 plugin"
HOMEPAGE = "https://github.com/sjaehn/BJumblr"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    libsndfile1 \
    cairo \
    lv2 \
"

SRC_URI = " \
    git://github.com/sjaehn/BJumblr.git \
    file://0001-BJumblr.cpp-Fix-build-with-gcc10.patch \
"
SRCREV = "4f906ea47467637a6e115435784dc34f6bf63ca7"
S = "${WORKDIR}/git"
PV = "1.2.2"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES_${PN} += "${libdir}/lv2"
