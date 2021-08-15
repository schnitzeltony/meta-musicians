SUMMARY = "Collection of LV2 plugins for audio-level metering"
HOMEPAGE = "http://x42.github.io/meters.lv2/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libgl \
    libglu \
    glib-2.0 \
    pango \
    cairo \
    lv2 \
    jack \
    fftw \
"

SRC_URI = "gitsm://github.com/x42/meters.lv2.git"
SRCREV = "7416ef980c2e7e0fb484460ba40c05ca37a22cde"
PV = "0.9.18"
S = "${WORKDIR}/git"

REQUIRED_DISTRO_FEATURES = "x11 opengl"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES:${PN} += "${libdir}/lv2"
