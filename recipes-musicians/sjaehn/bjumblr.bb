SUMMARY = "Pattern-controlled audio stream / sample re-sequencer LV2 plugin"
HOMEPAGE = "https://github.com/sjaehn/BJumblr"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    libsndfile1 \
    cairo \
    lv2 \
"

SRC_URI = "git://github.com/sjaehn/BJumblr.git;branch=master;protocol=https"
SRCREV = "eeafe2d0a7d856eb990cb0f7725e82195ff80c71"
S = "${WORKDIR}/git"
PV = "1.6.8"

EXTRA_OEMAKE = "STRIP=echo STRIPFLAG=-e"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES:${PN} += "${libdir}/lv2"
