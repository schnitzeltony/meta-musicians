SUMMARY = "Musical Instrument Tuner"
HOMEPAGE = "http://x42-plugins.com/x42/x42-tuner"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pkgconfig

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

SRC_URI = "gitsm://github.com/x42/tuna.lv2.git"
SRCREV = "0ce119e0a2b53fab9c2f8fdfe7cbd901963c720c"
PV = "0.4.14"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES_${PN} += "${libdir}/lv2"
