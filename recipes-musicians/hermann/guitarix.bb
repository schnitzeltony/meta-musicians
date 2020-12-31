SUMMARY = "A virtual guitar amplifier"
HOMEPAGE = "http://guitarix.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=384f45fb7968a0fe30622ce6160d3b69"

SRC_URI = " \
    git://github.com/brummer10/guitarix.git \
    file://0001-Rework-messages-somehow-yes-or-no-is-missing.patch \
    file://0002-Do-not-strip-LV2-plugins.patch \
"
SRCREV = "a14b455d4d258917a597456c674b6f80470e1d80"
PV = "0.42.1"
S = "${WORKDIR}/git/trunk"

inherit waf fontcache gettext

DEPENDS += " \
    gperf-native \
    intltool-native \
    sassc-native \
    boost \
    libeigen \
    avahi \
    gtkmm3 \
    jack \
    lilv \
    ladspa-sdk \
    libsndfile1 \
    lrdf \
    zita-resampler \
    zita-convolver \
"

PACKAGECONFIG[bluez] = ",--no-bluez,bluez5"

EXTRA_OECONF = " \
    --disable-sse \
    --bindir=${bindir} \
    --libdir=${libdir} \
    --ldflags="${LDFLAGS}" \
    --no-ldconfig \
    --no-desktop-update \
    --shared-lib \
    --lib-dev \
    --install-roboto-font \
    --no-faust \
"

python waf_preconfigure() {
}

PATH_prepend = "${B}:"

do_configure_prepend() {
    # link python -> python3
    ln -sf `which python3` ${B}/python
}

do_compile_prepend() {
    export STRIP=echo
}

do_install_append() {
    # some corrections [dev-elf] - inspired by https://src.fedoraproject.org/rpms/guitarix/blob/master/f/guitarix.spec
    chmod 755 ${D}${libdir}/libgxw*.so.0.1
    rm -rf ${D}${libdir}/libgxw*.so
    ln -sf libgxwmm.so.0.1 ${D}${libdir}/libgxwmm.so
    ln -sf libgxw.so.0.1 ${D}${libdir}/libgxw.so
}

FILES_${PN} += " \
    ${datadir}/fonts \
    ${datadir}/gx_head \
    ${datadir}/ladspa \
    ${libdir}/ladspa \
    ${libdir}/lv2 \
"
