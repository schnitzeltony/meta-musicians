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

SRC_URI = "git://github.com/sjaehn/BJumblr.git"
SRCREV = "bf1a0a076c15a641f6d213afcb0f4b9245c87d18"
S = "${WORKDIR}/git"
PV = "1.6.6"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES_${PN} += "${libdir}/lv2"
